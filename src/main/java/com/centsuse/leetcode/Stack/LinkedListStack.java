package com.centsuse.leetcode.Stack;

import com.centsuse.leetcode.LinkedList.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-24 22:28
 **/
public class LinkedListStack<E> implements StackInterface<E> {

    private LinkedList<E> data;

    private int size;

    LinkedListStack() {
        data = new LinkedList<E>();
        size = 0;
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "data=" + data +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
