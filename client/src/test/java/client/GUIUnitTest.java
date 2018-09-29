package client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import client.gui.GUI;
import client.gui.GUIpanel;

@RunWith(JUnit4.class) 
public class GUIUnitTest {

	private IClient cl;
	private GUI frame;
	private WireMockServer mockedServer;

	@Before
	public void setUp() throws AWTException {
		frame = GUI.createGui(true);
		frame.mockClient(cl = Mockito.mock(IClient.class));
		frame.setGridEnabled(true);
		frame.setPathEnabled(true);
	}
	@Test
	public void testHiddenCreation() {
		assertFalse(frame.getFrame().isVisible());
	}
	
	@Test
	public void testCreateConnector() {
		IRestServiceClient expected = new RestServiceClient("http://localhost:8080/api/");
		String expectedHost = expected.getHost();
		assertEqualityOfRestServiceClient(expectedHost);
		assertFalse(frame.isConnCreated());
		runServerToVerifyCreationOfConnector();
		assertEqualityOfRestServiceClient(expectedHost);
		assertTrue(frame.isConnCreated());
	}
	private void runServerToVerifyCreationOfConnector() {
		mockedServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080));
		WireMock.configureFor("localhost", 8080);
		mockedServer.start();
		stubFor(get(urlEqualTo("/api/"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("")));
	}
	private void assertEqualityOfRestServiceClient(String expectedHost) {
		frame.createConnection("localhost", "8080");
		IRestServiceClient actual = frame.getClient().getRestServiceClient();
		assertEquals(expectedHost, actual.getHost());
	}

	@Test
	public void testSetNullClientRequestGrid() {
		frame.mockClient(null);
		assertNull(frame.caseRequestGrid(""));
	}

	@Test
	public void testSetNullClientRequestAll() {
		frame.mockClient(null);
		assertTrue(frame.requestAll().isEmpty());
	}

	@Test
	public void testSetNullClientRequestPath() {
		frame.mockClient(null);
		assertTrue(frame.caseRequestPath("", "", "").isEmpty());
	}

	@Test
	public void testRetrieveAllGridsWhenEmptyList() throws IOException {
		when(cl.getAllTables()).thenReturn(Arrays.asList());
		List<String> list = frame.requestAll();
		assertEquals(Arrays.asList(), list);
		verify(cl, times(1)).getAllTables();
	}

	@Test
	public void testRetrieveAllGridsWhenSingleList() throws IOException {
		when(cl.getAllTables()).thenReturn(Arrays.asList("1"));
		List<String> list = frame.requestAll();
		assertEquals(Arrays.asList("1"), list);
		verify(cl, times(1)).getAllTables();
	}

	@Test
	public void testRetrieveAllGridsWhenNormalList() throws IOException {
		when(cl.getAllTables()).thenReturn(Arrays.asList("1", "2"));
		List<String> list = frame.requestAll();
		assertEquals(Arrays.asList("1", "2"), list);
		verify(cl, times(1)).getAllTables();
	}

	@Test
	public void testRetrieveAllGridsWhenNullPointerException() throws IOException {
		throwWhenRetrieveAll(new NullPointerException());
	}

	private void throwWhenRetrieveAll(Exception exc) throws IOException {
		when(cl.getAllTables()).thenThrow(exc);
		assertEquals(Arrays.asList(), frame.requestAll());
	}

	@Test
	public void testRetrieveAllGridsWhenIOException() throws IOException {
		throwWhenRetrieveAll(new IOException());
	}

	@Test
	public void testRetrieveOneGridWhenIOException() throws IOException {
		throwWhenRetrieveGrid(new IOException());
	}

	@Test
	public void testRetrieveOneGridWhenNullPointerException() throws IOException {
		throwWhenRetrieveGrid(new NullPointerException());
	}

	@Test
	public void testRetrieveOneGridWhenOk() throws IOException {
		when(cl.retrieveGrid("1")).thenReturn(new GridFromServer());
		GridFromServer retrieved = frame.caseRequestGrid("1");
		verify(cl, times(1)).retrieveGrid("1");
		assertEquals(new GridFromServer(), retrieved);
	}

	private void throwWhenRetrieveGrid(Exception exc) throws IOException {
		when(cl.retrieveGrid("1")).thenThrow(exc);
		GridFromServer retrieved = frame.caseRequestGrid("1");
		assertNull(retrieved);
	}

	@Test
	public void testGetShortestPathWhenMissingSink() throws IOException {
		List<String> path = frame.caseRequestPath("0_0", "", "1");
		assertEquals(Arrays.asList(), path);
	}

	@Test
	public void testGetShortestPathWhenMissingSource() throws IOException {
		List<String> path = frame.caseRequestPath("", "0_1", "1");
		assertEquals(Arrays.asList(), path);
	}

	@Test
	public void testGetShortestPathWhenMissingWhere() throws IOException {
		List<String> path = frame.caseRequestPath("0_0", "0_1", "");
		assertEquals(Arrays.asList(), path);
	}

	@Test
	public void testGetShortestPathWhenOKEmptyList() throws IOException {
		assertExpectedPath(Arrays.asList());
	}

	@Test
	public void testGetShortestPathWhenOKSingleList() throws IOException {
		assertExpectedPath(Arrays.asList("0_0"));
	}

	@Test
	public void testGetShortestPathWhenOKNormalList() throws IOException {
		assertExpectedPath(Arrays.asList("0_0", "0_1"));
	}

	@Test
	public void testGetShortestPathWhenIOException() throws IOException {
		assertExpectedPathException(new IOException());
	}

	@Test
	public void testGetShortestPathWhenNullPointerException() throws IOException {
		assertExpectedPathException(new NullPointerException());
	}

	@Test
	public void testGetShortestPathWhenNotEnabled() throws IOException {
		frame.setPathEnabled(false);
		assertExpectedPath(Arrays.asList());
	}

	@Test
	public void testGetGridWhenNotEnabled() throws IOException {
		frame.setGridEnabled(false);
		GridFromServer grid = frame.caseRequestGrid("");
		assertNull(grid);
	}

	@Test
	public void testResetPane() {
		frame.mockPane(Mockito.spy(new GUIpanel(10)));
		frame.resetPane();
		verify(frame.getGuiPanel(), times(1)).reset();
	}
	private void assertExpectedPath(List<String> expected) throws IOException {
		when(cl.getShortestPath("0_0", "0_1", "1")).thenReturn(expected);
		List<String> path = frame.caseRequestPath("0_0", "0_1", "1");
		assertEquals(expected, path);
	}

	private void assertExpectedPathException(Exception e) throws IOException {
		when(cl.getShortestPath("0_0", "0_1", "1")).thenThrow(e);
		List<String> path = frame.caseRequestPath("0_0", "0_1", "1");
		assertEquals(Arrays.asList(), path);
	}

}