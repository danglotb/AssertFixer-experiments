package org.openlcb.messages;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.JUnit4TestAdapter;

/**
 * @author  Bob Jacobsen   Copyright 2009, 2012
 * @version $Revision$
 */
public class PackageTest extends TestCase {
    public void testStart() {
    }
    
    // from here down is testing infrastructure
    
    public PackageTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {PackageTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(PackageTest.class);

        suite.addTest(TractionControlRequestMessageTest.suite());
        suite.addTest(new JUnit4TestAdapter(TractionControlReplyMessageTest.class));       
        suite.addTest(new JUnit4TestAdapter(TractionProxyRequestMessageTest.class));       
        suite.addTest(new JUnit4TestAdapter(TractionProxyReplyMessageTest.class));       

        return suite;
    }
}
