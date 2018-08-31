/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage.junitrunner;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.VerboseMockitoJUnitRunner;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;

//@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
@RunWith(VerboseMockitoJUnitRunner.class)
@Ignore
public class ModellingVerboseMockitoTest extends TestBase {
    
    @Mock private IMethods mock;     
    
    @Before
    public void cleanStackTraces() {
        super.makeStackTracesClean();
    }
    
    @Test
    public void shouldLogUnusedStubbingWarningWhenTestFails() throws Exception {
        when(mock.simpleMethod(1)).thenReturn("foo");
        when(mock.otherMethod()).thenReturn("foo");
        when(mock.booleanObjectReturningMethod()).thenReturn(false);

        //TODO: stubbed with those args here -> stubbed with certain args here 
        String ret = mock.simpleMethod(2);

        assertEquals("foo", ret);
        //TODO: should show message from actual failure not at the bottom but at least below 'the actual failure is ...'
    }
       

    @Test
    public void shouldNotLogAnythingWhenNoWarnings() throws Exception {
        //stub
        when(mock.simpleMethod()).thenReturn("foo");
        //use stub:
        mock.simpleMethod();
        //verify:
        verify(mock).simpleMethod();
        //should be no warnings:
        fail();
    }

//    @After
//    public void checkStubs() {
////        stubsUsedIn(mock);
//    }
//
//    private void stubsUsed(Object ... mocks) {
//
//    }
//
//    private void stubsUsed(Object testCaseOrMock) {
//
//    }
}