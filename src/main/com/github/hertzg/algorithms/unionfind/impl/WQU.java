package com.github.hertzg.algorithms.unionfind.impl;

import java.util.Arrays;

public class WQU extends QU {

    protected long[] sz;

    public WQU(int n) {
        super(n);
    }

    @Override
    protected void initialize(int n) {
        ids = new int[n];
        sz = new long[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        if (p == q) return;
        int i = root(p), j = root(q);
        if (sz[i] >= sz[j]) unionUnder(i, j);
        else unionUnder(j, i);
    }

    protected void unionUnder(int largerTreeId, int smallerTreeId) {
        if (largerTreeId == smallerTreeId) return;
        ids[smallerTreeId] = largerTreeId;
        sz[largerTreeId] = Math.addExact(sz[largerTreeId], sz[smallerTreeId]);
    }

    public double averageSize() throws Exception {
        return Arrays.stream(sz).average().orElse(-1);
    }
}
