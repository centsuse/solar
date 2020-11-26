package com.centsuse.leetcode.UnionFind;

import java.util.Random;

/**
 * @author centsuse
 * @DESCRIPTION UnionFind
 * @create 2020-07-13 23:09
 **/
public class UF implements UnionFindInterface {

    private int[] parent;

    private int[] rank;

    public UF(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        if (p < 0 || p >= getSize()) {
            throw new IllegalArgumentException("error index");
        }
        // 递归，直接压缩成指向根节点情况
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        // 迭代，无法一次直接压缩成指向根节点情况，需要多次查找
//        while (p != parent[p]) {
//            p = parent[p];
//        }
        return parent[p];
    }

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        UF uf = new UF(9);
//        uf.unionElement(1, 3);
//        uf.unionElement(1, 5);
//        System.out.println(uf.isConnected(3, 5));
//        System.out.println(uf.isConnected(1, 5));
//        System.out.println(uf.isConnected(1, 3));
//        System.out.println(uf.isConnected(1, 2));


        int size = 10000000;
        int m = 10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");
//
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        UF uf = new UF(size);
        System.out.println("UnionFind3 : " + testUF(uf, m) + " s");
    }
}
