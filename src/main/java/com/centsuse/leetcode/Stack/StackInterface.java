package com.centsuse.leetcode.Stack;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-20 0:07
 **/
public interface StackInterface<E> {

    int a = 10;

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
