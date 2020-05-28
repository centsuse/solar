package com.centsuse.leetcode.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION 带虚拟头结点的单链表
 * @create 2020-05-24 21:30
 **/
public class LinkedList<E> implements LinkedListInterface<E> {

    class Node {

        E e;

        Node next;

        Node(E e) {
            this.e = e;
            this.next = null;
        }

        Node() {
            this.e = null;
            this.next = null;
        }

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    /** 链表长度 */
    private int size;

    /** 头结点，第一个节点为虚拟头结点 */
    private Node head;

    public LinkedList(E e) {
        this.head = new Node();
        this.head.next = new Node(e);
        this.size++;
    }

    public LinkedList() {
        this.head = new Node();
        this.size = 0;
    }

    @Override
    public void add(int index, E e) {
        // 1) 获取index前驱节点
        // 2) 把前驱节点的next指向新节点
        // 3) 把新节点的netx指向原来index节点
        // 4) size++
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node oldIndex = pre.next;
        pre.next = new Node(e, oldIndex);
        size++;
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void addLast(E e) {
        this.add(size , e);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Error index");
        }
        Node preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Linkedlist is empty");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        // 是否需要校验cur.next为null？
        return cur.next.e;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Linkedlist is empty");
        }
        return this.get(0);
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Linkedlist is empty");
        }
        return this.get(size - 1);
    }

    @Override
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        Node node = head.next;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (e.equals(node.e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List size is ").append(size);
        sb.append(", [demmyHead -> ");
        Node node = this.head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            sb.append(node.e);
            if (i != size - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(5);
        linkedList.add(1, 10);
        linkedList.remove(1);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
