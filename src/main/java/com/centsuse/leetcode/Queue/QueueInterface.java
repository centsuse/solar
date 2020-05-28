package com.centsuse.leetcode.Queue;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-21 21:39
 **/
public interface QueueInterface<E> {

    void enqueue(E e);

    E dequeue();

    E front();

    int getCapacity();

    boolean isEmpty();
}
