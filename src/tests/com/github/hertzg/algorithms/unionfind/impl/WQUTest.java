package com.github.hertzg.algorithms.unionfind.impl;

import com.github.hertzg.algorithms.unionfind.ImplTest;
import com.github.hertzg.algorithms.unionfind.UnionFind;
import com.github.hertzg.algorithms.unionfind.UnionFindFactory;

public class WQUTest extends ImplTest {

    @Override
    public UnionFind createInstance(int n) {
        return UnionFindFactory.weightedQuickUnion(n);
    }
}
