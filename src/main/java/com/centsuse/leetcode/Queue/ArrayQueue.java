package com.centsuse.leetcode.Queue;

import com.centsuse.leetcode.Array.Array;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-21 21:39
 **/
public class ArrayQueue<E> implements QueueInterface<E> {

    private Array<E> arrayQueue;

    public ArrayQueue(int capacity) {
        this.arrayQueue = new Array(capacity);
    }

    public ArrayQueue() {
        this.arrayQueue = new Array();
    }

    /**
     * 时间复杂度 O(1)
     * @param e
     */
    @Override
    public void enqueue(E e) {
        this.arrayQueue.addLast(e);
    }

    /**
     * 时间复杂度 O(n):较大，需要优化，使用循环队列
     * @return
     */
    @Override
    public E dequeue() {
        return this.arrayQueue.removeFirst();
    }

    @Override
    public E front() {
        return this.arrayQueue.getFirst();
    }

    @Override
    public int getCapacity() {
        return this.arrayQueue.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayQueue.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < arrayQueue.getSize() ; i ++){
            res.append(arrayQueue.get(i));
            if(i != arrayQueue.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
