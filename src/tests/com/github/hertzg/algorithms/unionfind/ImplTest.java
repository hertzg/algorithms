package com.github.hertzg.algorithms.unionfind;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class ImplTest {

    @Rule
    public Timeout timeout = Timeout.seconds(5);

    public abstract UnionFind createInstance(int n);

    @Test
    public void simpleTest() {
        UnionFind unionFind = createInstance(6);

        unionFind.union(0, 1);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 5);

        assertTrue(unionFind.connected(0, 1));
        assertTrue(unionFind.connected(0, 2));
        assertTrue(unionFind.connected(0, 3));
        assertTrue(unionFind.connected(0, 5));
        assertTrue(unionFind.connected(1, 2));
        assertTrue(unionFind.connected(1, 3));
        assertTrue(unionFind.connected(1, 5));
        assertTrue(unionFind.connected(2, 3));
        assertTrue(unionFind.connected(2, 5));
        assertTrue(unionFind.connected(3, 5));
        assertFalse(unionFind.connected(0, 4));
        assertFalse(unionFind.connected(1, 4));
        assertFalse(unionFind.connected(2, 4));
        assertFalse(unionFind.connected(3, 4));
        assertFalse(unionFind.connected(5, 4));
    }

    @Test
    public void simpleTest2() {
        UnionFind unionFind = createInstance(6);

        unionFind.union(0, 1);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 5);
        unionFind.union(0, 4);

        assertTrue(unionFind.connected(0, 1));
        assertTrue(unionFind.connected(0, 2));
        assertTrue(unionFind.connected(0, 3));
        assertTrue(unionFind.connected(0, 5));
        assertTrue(unionFind.connected(1, 2));
        assertTrue(unionFind.connected(1, 3));
        assertTrue(unionFind.connected(1, 5));
        assertTrue(unionFind.connected(2, 3));
        assertTrue(unionFind.connected(2, 5));
        assertTrue(unionFind.connected(3, 5));
        assertTrue(unionFind.connected(0, 4));
        assertTrue(unionFind.connected(1, 4));
        assertTrue(unionFind.connected(2, 4));
        assertTrue(unionFind.connected(3, 4));
        assertTrue(unionFind.connected(5, 4));
    }

    @Test
    public void simpleTest3() {
        UnionFind unionFind = createInstance(6);

        unionFind.union(0, 1);
        unionFind.union(2, 3);
        unionFind.union(4, 5);

        assertTrue(unionFind.connected(0, 0));
        assertTrue(unionFind.connected(0, 1));
        assertFalse(unionFind.connected(0, 2));
        assertFalse(unionFind.connected(0, 3));
        assertFalse(unionFind.connected(0, 4));
        assertFalse(unionFind.connected(0, 5));

        assertTrue(unionFind.connected(1, 0));
        assertTrue(unionFind.connected(1, 1));
        assertFalse(unionFind.connected(1, 2));
        assertFalse(unionFind.connected(1, 3));
        assertFalse(unionFind.connected(1, 4));
        assertFalse(unionFind.connected(1, 5));

        assertFalse(unionFind.connected(2, 0));
        assertFalse(unionFind.connected(2, 1));
        assertTrue(unionFind.connected(2, 2));
        assertTrue(unionFind.connected(2, 3));
        assertFalse(unionFind.connected(2, 4));
        assertFalse(unionFind.connected(2, 5));

        assertFalse(unionFind.connected(3, 0));
        assertFalse(unionFind.connected(3, 1));
        assertTrue(unionFind.connected(3, 2));
        assertTrue(unionFind.connected(3, 3));
        assertFalse(unionFind.connected(3, 4));
        assertFalse(unionFind.connected(3, 5));

        assertFalse(unionFind.connected(4, 0));
        assertFalse(unionFind.connected(4, 1));
        assertFalse(unionFind.connected(4, 2));
        assertFalse(unionFind.connected(4, 3));
        assertTrue(unionFind.connected(4, 4));
        assertTrue(unionFind.connected(4, 5));
    }


    @Test
    public void testRandomUnions() {
        int n = 99999;
        testNRandomUnions(n);
    }

    @Test
    public void testContinuousUnions() {
        int n = 99999;
        testNContinuousUnions(n);
    }

    @Test()
    public void testHugeRandomUnions() {
        int n = 9999999;
        testNRandomUnions(n);
    }

    @Test
    public void testHugeContinuousUnions() {
        int n = 9999999;
        testNContinuousUnions(n);
    }

    protected void testNRandomUnions(int n) {
        int[] pairs = createRandomPairs(n);

        UnionFind unionFind = createInstance(n);
        for (int i = 0; i < pairs.length; i += 2) {
            unionFind.union(pairs[i], pairs[i + 1]);
        }

        for (int i = 0; i < pairs.length; i += 2) {
            assertTrue(unionFind.connected(pairs[i], pairs[i + 1]));
            assertTrue(unionFind.connected(pairs[i + 1], pairs[i]));
        }
    }

    protected void testNContinuousUnions(int n) {
        int[] pairs = createContinuousPairs(n);

        UnionFind unionFind = createInstance(n);
        for (int i = 0; i < pairs.length; i += 2) {
            unionFind.union(pairs[i], pairs[i + 1]);
        }

        for (int i = 0; i < pairs.length; i += 2) {
            assertTrue(unionFind.connected(pairs[i], pairs[i + 1]));
            assertTrue(unionFind.connected(pairs[i + 1], pairs[i]));
        }
    }

    public static int[] createRandomPairs(int n) {
        Random rng = new Random();
        int[] pairs = new int[2 * n];
        for (int i = 0; i < n; i += 2) {
            int p, q;
            do {
                p = rng.nextInt(n);
                q = rng.nextInt(n);
            } while (p == q);
            pairs[i] = p;
            pairs[i + 1] = q;
        }
        return pairs;
    }

    public static int[] createContinuousPairs(int n) {
        boolean nIsOdd = n % 2 == 1;
        int[] pairs = new int[2 * n];
        int nn = nIsOdd ? n - 1 : n;
        for (int i = 0; i < nn; i += 2) {
            pairs[i] = i;
            pairs[i + 1] = i + 1;
        }
        if (nIsOdd) {
            pairs[n - 2] = 0;
            pairs[n - 1] = n - 1;
        }
        return pairs;
    }

}
