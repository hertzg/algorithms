package com.github.hertzg.algorithms.unionfind.impl;

import com.github.hertzg.algorithms.unionfind.ImplTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QUComparisonTests {

    @Test
    public void weightedDepthTestHugeContinuousPairs() throws Exception {
        int n = 100000000;
        WQU quickUnion = new WQU(n);
        WQU weightedQuickUnion = new WQU(n);

        for (int k = 0; k < 100; k++) {
            for (int j = 0; j < 100; j++) {
                int[] pairs = ImplTest.createContinuousPairs(10000);
                for (int i = 0; i < pairs.length; i += 2) {
                    quickUnion.unionUnder(pairs[i] * j * k, pairs[i + 1] * j * k);
                    weightedQuickUnion.union(pairs[i] * j * k, pairs[i + 1] * j * k);
                }
            }
        }

        double qS = quickUnion.averageSize(), wS = weightedQuickUnion.averageSize();
        assertTrue(String.format("%f should be greater than %f", qS, wS), qS > wS);
    }


    @Test
    public void weightedDepthTestHugeRandomPairs() throws Exception {
        int n = 10000000;

        WQU quickUnion = new WQU(n);
        WQU weightedQuickUnion = new WQU(n);

        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                int[] pairs = ImplTest.createRandomPairs(100000);
                for (int i = 0; i < pairs.length; i += 2) {
                    quickUnion.unionUnder(pairs[i] * j * k, pairs[i + 1] * j * k);
                    weightedQuickUnion.union(pairs[i] * j * k, pairs[i + 1] * j * k);
                }
            }
        }

        double qS = quickUnion.averageSize(), wS = weightedQuickUnion.averageSize();
        assertTrue(String.format("%f should be greater than %f", qS, wS), qS > wS);
    }

}
