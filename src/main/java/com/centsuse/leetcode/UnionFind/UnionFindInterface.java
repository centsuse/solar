package com.centsuse.leetcode.UnionFind;

/**
 * @author centsuse
 * @DESCRIPTION UnionFindInterface
 * @create 2020-07-13 23:10
 **/
public interface UnionFindInterface {

    int getSize();

    void unionElement(int p, int q);

    boolean isConnected(int p, int q);
}
