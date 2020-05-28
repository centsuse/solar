package com.centsuse.leetcode.Queue;

import java.util.Arrays;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-21 22:48
 **/
public class LoopQueue<E> implements QueueInterface<E> {

    /**
     * 循环队列，tail == front，表示队列为空
     * (tail + 1) % data.length == front，表示队列满了
     * 实际容量比真实容量大1
     */

    private E[] data;

    /** 队首的索引 */
    private int front;

    /** 队尾的索引 */
    private int tail;

    /** 队列大小 */
    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        /** 如果满了，则扩容 */
        if ((this.tail + 1) % this.data.length == front) {
            resize(this.getCapacity() * 2);
        }
        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        E e = this.data[this.front];
//        System.out.println(e);
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;
        if (this.size <= this.getCapacity() / 4  && this.getCapacity() / 2 != 0) {
            resize(this.getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return this.data[front];
    }

    @Override
    public int getCapacity() {
        return this.data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * 扩容
     * @param capacity
     */
    private void resize(int capacity) {
//        System.out.println("resize");
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = this.data[(i + this.front) % this.data.length];
        }
        this.front = 0;
        this.tail = size;
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size is ").append(this.size).append(", ");
        sb.append("capacity is ").append(getCapacity()).append(", ");
        sb.append("front is [");
        for (int i = this.front; i != this.tail; i = (i + 1) % this.data.length) {
            sb.append(this.data[i]);
            if ((i + 1) % this.data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] to tail");
        return sb.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
        loopQueue.enqueue(4);
        loopQueue.enqueue(5);
        loopQueue.enqueue(6);
        loopQueue.enqueue(7);
        loopQueue.enqueue(8);
        loopQueue.enqueue(9);
        loopQueue.enqueue(10);
        loopQueue.enqueue(11);
        loopQueue.enqueue(11);
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue);
    }
}
