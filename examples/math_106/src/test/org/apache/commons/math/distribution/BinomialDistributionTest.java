/*
 * Copyright 2003-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math.distribution;

/**
 * Test cases for BinomialDistribution.
 * Extends IntegerDistributionAbstractTest.  See class javadoc for
 * IntegerDistributionAbstractTest for details.
 * 
 * @version $Revision$ $Date$
 */
public class BinomialDistributionTest extends IntegerDistributionAbstractTest {
    
    /**
     * Constructor for BinomialDistributionTest.
     * @param name
     */
    public BinomialDistributionTest(String name) {
        super(name);
    }
    
    //-------------- Implementations for abstract methods -----------------------
    
    /** Creates the default discrete distribution instance to use in tests. */
    public IntegerDistribution makeDistribution() {
        return DistributionFactory.newInstance().createBinomialDistribution(10,0.70);
    }
    
    /** Creates the default probability density test input values */
    public int[] makeDensityTestPoints() {
        return new int[] {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    }
    
    /** Creates the default probability density test expected values */
    public double[] makeDensityTestValues() {
        return new double[] {0d, 0.0000d, 0.0001d, 0.0014d, 0.0090d, 0.0368d, 0.1029d, 
                0.2001d, 0.2668d, 0.2335d, 0.1211d, 0.0282d, 0d};
    }
    
    /** Creates the default cumulative probability density test input values */
    public int[] makeCumulativeTestPoints() {
        return makeDensityTestPoints();
    }
    
    /** Creates the default cumulative probability density test expected values */
    public double[] makeCumulativeTestValues() {
        return new double[] {0d, 0.0000d, 0.0001d, 0.0016d, 0.0106d, 0.0473d,
                0.1503d, 0.3504d, 0.6172d, 0.8507d, 0.9718d, 1d, 1d};
        }
    
    /** Creates the default inverse cumulative probability test input values */
    public double[] makeInverseCumulativeTestPoints() {
        return new double[] {0, 0.001d, 0.010d, 0.025d, 0.050d, 0.100d, 0.999d,
                0.990d, 0.975d, 0.950d, 0.900d,1}; 
        }
    
    /** Creates the default inverse cumulative probability density test expected values */
    public int[] makeInverseCumulativeTestValues() {
        return new int[] {-1, 1, 2, 3, 4, 4, 9, 9, 9, 8, 8, Integer.MAX_VALUE};
    }

    //----------------- Additional test cases ---------------------------------
   
    /** Test degenerate case p = 0   */
    public void testDegenerate0() throws Exception {
        setDistribution(DistributionFactory.newInstance().createBinomialDistribution(5,0.0d));
        setCumulativeTestPoints(new int[] {-1, 0, 1, 5, 10 });
        setCumulativeTestValues(new double[] {0d, 1d, 1d, 1d, 1d});
        setDensityTestPoints(new int[] {-1, 0, 1, 10, 11});
        setDensityTestValues(new double[] {0d, 1d, 0d, 0d, 0d});
        setInverseCumulativeTestPoints(new double[] {0.1d, 0.5d});
        setInverseCumulativeTestValues(new int[] {-1, -1});
        verifyDensities();
        verifyCumulativeProbabilities();
        verifyInverseCumulativeProbabilities();     
    }
    
    /** Test degenerate case p = 1   */
    public void testDegenerate1() throws Exception {
        setDistribution(DistributionFactory.newInstance().createBinomialDistribution(5,1.0d));
        setCumulativeTestPoints(new int[] {-1, 0, 1, 2, 5, 10 });
        setCumulativeTestValues(new double[] {0d, 0d, 0d, 0d, 1d, 1d});
        setDensityTestPoints(new int[] {-1, 0, 1, 2, 5, 10});
        setDensityTestValues(new double[] {0d, 0d, 0d, 0d, 1d, 0d});
        setInverseCumulativeTestPoints(new double[] {0.1d, 0.5d});
        setInverseCumulativeTestValues(new int[] {4, 4});
        verifyDensities();
        verifyCumulativeProbabilities();
        verifyInverseCumulativeProbabilities();     
    }

}
