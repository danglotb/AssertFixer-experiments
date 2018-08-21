/*
 * Copyright (c) 2018 The University of Manchester
 */
package uk.ac.manchester.spinnaker.utils;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Christian-B
 */
public class TestTripleMapIterable {

    @Test
    public void testMultiple() {
        Map<Float, Map<Double, Map<String, Integer>>> bigMap = new HashMap();

        Map<Double, Map<String, Integer>> aMap = new HashMap();

        Map<String, Integer> inner = new HashMap();
        inner.put("One", 1);
        inner.put("Two", 2);
        inner.put("Three", 3);
        aMap.put(23.2, inner);

        Map<String, Integer> inner2 = new HashMap();
        inner2.put("Ten", 10);
        inner2.put("Eleven", 11);
        inner2.put("Twelve", 12);
        aMap.put(43.6, inner2);

        bigMap.put((float)0.5, aMap);

        Map<Double, Map<String, Integer>> aMap2 = new HashMap();

        Map<String, Integer> inner11 = new HashMap();
        inner.put("Un", -1);
        inner.put("Duex", -2);
        inner.put("Trois", -3);
        aMap2.put(423.2, inner11);

        Map<String, Integer> inner12 = new HashMap();
        inner2.put("Dix", -10);
        inner2.put("Onze", -11);
        inner2.put("Douze", -12);
        aMap2.put(4.6, inner12);

        bigMap.put((float)2.5, aMap2);

        TripleMapIterable<Integer> instance;
        instance = new TripleMapIterable(bigMap);
        int count = 0;
        for (Integer value: instance) {
            count += 1;
        }
        assertEquals(12, count);
        for (Integer value: instance) {
            count += 1;
        }
        assertEquals(24, count);
    }

    @Test
    public void testEmpty() {
        Map<Float, Map<Double, Map<String, Integer>>> bigMap = new HashMap();

        TripleMapIterable<Integer> instance;
        instance = new TripleMapIterable(bigMap);
        int count = 0;
        for (Integer value: instance) {
            count += 1;
        }
        assertEquals(0, count);
    }


}
