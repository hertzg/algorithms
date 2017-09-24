package com.github.hertzg.algorithms.unionfind.impl;

import com.github.hertzg.algorithms.unionfind.UnionFind;

public class QF implements UnionFind {

    private int[] ids;

    public QF(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int pId = ids[p], qId = ids[q];
        for (int i = 0; i < ids.length; i++)
            if (ids[i] == pId) ids[i] = qId;
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }
}
