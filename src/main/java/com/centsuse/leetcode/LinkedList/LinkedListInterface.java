package com.centsuse.leetcode.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-24 21:38
 **/
public interface LinkedListInterface<E> {

    void add(int index, E e);

    E remove(int index);

    E get(int index);

    boolean contains(E e);

    boolean isEmpty();
}
