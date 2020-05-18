package com.centsuse.leetcode.Array;

import java.util.Arrays;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-17 23:54
 **/
public class Array<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int size;

    private E[] array;

    private Array() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    private Array(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    private int getSize() {
        return this.size;
    }

    private int getCapacity() {
        return this.capacity;
    }

    private boolean isEmpty() {
        return 0 == this.size;
    }

    private E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("error index");
        }
        return array[index];
    }

    private void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("error index");
        }
        array[index] = e;
    }

    /**
     * 在index处添加元素，时间复杂度O(n),最坏为O(n),最好为O(1)
     * @param index
     * @param e
     */
    private void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("error index");
        }
        /** 如果范围超过了当前的容量,扩容 */
        if (size == capacity) {
            resize(this.capacity * 2);
        }
        for (int i = size - 1; index <= i; i--) {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = e;
    }

    /**
     * 在数组头添加元素，时间复杂度O(1)
     * @param e
     */
    private void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在末尾添加元素，时间复杂度O(n)
     * @param e
     */
    private void addLast(E e) {
        add(size, e);
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    private E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("error index");
        }
        E e = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        /** 如果当前的size等于最大容量的1/4，则缩小容量为1/2 */
        if (size == this.capacity / 4 && this.capacity / 2 != 0) {
            resize(this.capacity / 2);
        }
        return e;
    }

    /**
     * 删除第一个元素
     * @return
     */
    private E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    private E removeLast() {
        return remove(size - 1);
    }

    /**
     * 动态调整数组大小
     * @param capacity
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = array[i];
        }
        this.array = newData;
        this.capacity = capacity;
    }

    private boolean contains(E e) {
        if (null == e) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        if (null == e) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        sb.append("], ");
        sb.append("size is ");
        sb.append(this.size);
        sb.append(", capacity is ");
        sb.append(this.capacity);
        return sb.toString();
    }

    public static void main(String[] args) {

        class Student {
            private int age;
            private String name;
        }

        Array array = new Array();
        array.addFirst(4);
        array.addFirst(3);
        array.addFirst(2);
        array.addFirst(1);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
//        array.addLast(7);
//        array.addLast(8);
        array.addLast(9);
        array.addLast(10);
        array.add(2, 21);
        System.out.println(array);
        System.out.println(array.find(7));
        System.out.println(array.contains(7));
//        System.out.println(array.remove(2));
//        System.out.println(array.removeFirst());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array.removeLast());
//        System.out.println(array);


        Array<Student> studentArray = new Array<>(5);
        for (int i = 0; i < 6; i++) {
            studentArray.addLast(new Student());
        }
        System.out.println(studentArray);
    }

}
