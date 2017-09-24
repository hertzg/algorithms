package com.github.hertzg.algorithms.unionfind.impl;

public class PCWQU extends WQU {

    public PCWQU(int n) {
        super(n);
    }

    @Override
    protected int root(int i) {
        int r = i;
        while (r != ids[r]) r = ids[r];
        while (i != ids[i]) {
            i = ids[i];
            ids[i] = r;
        }
        return r;
    }
}
