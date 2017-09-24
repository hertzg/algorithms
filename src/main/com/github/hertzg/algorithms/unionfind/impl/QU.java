package com.github.hertzg.algorithms.unionfind.impl;

import com.github.hertzg.algorithms.unionfind.UnionFind;

public class QU implements UnionFind {
    protected int[] ids;

    public QU(int n) {
        initialize(n);
    }

    protected void initialize(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p), j = root(q);
        ids[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    protected int root(int i) {
        while (i != ids[i]) i = ids[i];
        return i;
    }
}
