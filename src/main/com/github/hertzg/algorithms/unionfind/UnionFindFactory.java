package com.github.hertzg.algorithms.unionfind;

import com.github.hertzg.algorithms.unionfind.impl.PCWQU;
import com.github.hertzg.algorithms.unionfind.impl.QF;
import com.github.hertzg.algorithms.unionfind.impl.QU;
import com.github.hertzg.algorithms.unionfind.impl.WQU;

public class UnionFindFactory {

    public static UnionFind quickFind(int n) {
        return new QF(n);
    }

    public static UnionFind quickUnion(int n) {
        return new QU(n);
    }

    public static UnionFind weightedQuickUnion(int n) {
        return new WQU(n);
    }

    public static UnionFind weightedQuickUnionWithPathCompression(int n) {
        return new PCWQU(n);
    }

}
