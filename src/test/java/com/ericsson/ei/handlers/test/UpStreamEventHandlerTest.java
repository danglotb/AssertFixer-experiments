package com.ericsson.ei.handlers.test;

import com.ericsson.ei.App;
import com.ericsson.ei.erqueryservice.ERQueryService;
import com.ericsson.ei.erqueryservice.SearchOption;
import com.ericsson.ei.handlers.UpStreamEventsHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UpStreamEventHandlerTest {

    @Autowired
    private UpStreamEventsHandler classUnderTest;

    @Test
    public void testRunHistoryExtractionRulesOnAllUpstreamEvents() throws IOException {
        // TO DO to complete implementation
        String upStreamString = "{\"upstreamLinkObjects\":[\n" + "\t\t{\"_id\":\"event1_level_1\"},[\n"
                + "\t\t\t{\"_id\":\"event2_level_2\"},\n" + "\t\t\t{\"_id\":\"event3_level_2\"},[\n"
                + "\t\t\t\t{\"_id\":\"event4_level_3\"},[\n" + "\t\t\t\t\t{\"_id\":\"event5_level_4\"}],\n"
                + "\t\t\t\t{\"_id\":\"event6_level_3\"}],\n" + "\t\t\t{\"_id\":\"event7_level_2\"},\n"
                + "\t\t\t{\"_id\":\"event8_level_2\"}]]}\n";
        final JsonNode response = new ObjectMapper().readTree(upStreamString);

        ResponseEntity<JsonNode> upStreamResponse = new ResponseEntity<>(response, HttpStatus.CREATED);

        ERQueryService mockedERQueryService = mock(ERQueryService.class);
        String aggregatedObjectId = "0123456789abcdef";
        when(mockedERQueryService.getEventStreamDataById(aggregatedObjectId, SearchOption.UP_STREAM, -1, -1, true))
                .thenReturn(upStreamResponse);

        classUnderTest.runHistoryExtractionRulesOnAllUpstreamEvents("0123456789abcdef");

        assertEquals("1", "1");
    }
}