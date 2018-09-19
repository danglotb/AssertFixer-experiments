package jmri.web.servlet.panel;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the jmri.web.servlet.panel.ControlPanelServlet class
 *
 * @author Paul Bender Copyright (C) 2012,2016
 */
public class ControlPanelServletTest {

    @Test
    public void testCtor() {
        ControlPanelServlet a = new ControlPanelServlet();
        Assert.assertNotNull(a);
    }

    @Before
    public void setUp() {
        JUnitUtil.setUp();

    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }
}
