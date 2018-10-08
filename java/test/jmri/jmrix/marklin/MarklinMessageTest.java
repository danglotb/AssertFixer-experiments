package jmri.jmrix.marklin;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class MarklinMessageTest extends jmri.jmrix.AbstractMessageTestBase {

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        m = new MarklinMessage();
    }

    @After
    public void tearDown() {
	m = null;
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(MarklinMessageTest.class);

}
