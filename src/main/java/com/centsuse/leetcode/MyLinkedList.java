package com.centsuse.leetcode;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-06-03 23:07
 **/
class MyLinkedList {

    /** Initialize your data structure here. */
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node dummyNode;
    int size;

    MyLinkedList() {
        // 虚拟头结点
        this.dummyNode = new Node(-1);
    }

    MyLinkedList(int val) {
        // 虚拟头结点
        this.dummyNode = new Node(-1);
        this.dummyNode.next = new Node(val);
        size++;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (null == dummyNode) {
            return -1;
        }
        Node node = dummyNode.next;
        for (int i = 0; i < index; i++) {
            if (null != node.next) {
                node = node.next;
            } else {
                return -1;
            }
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        Node preNode = dummyNode;
        for (int i = 0; i < index; i++) {
            if (null != preNode.next) {
                preNode = preNode.next;
            } else {
                return;
            }
        }
        preNode.next = new Node(val, preNode.next);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        Node curNode = dummyNode;
        for (int i = 0; i < index; i++) {
            if (null != curNode) {
                curNode = curNode.next;
            } else {
                return;
            }
        }
        curNode.next = curNode.next.next;
        size--;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node node = this.dummyNode.next;
            while (null != node) {
                sb.append(node.val);
                sb.append(",");
                node = node.next;
            }
            sb.append("]");
            return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        System.out.println(linkedList);
        linkedList.addAtTail(3);
        System.out.println(linkedList);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));          //返回2
        System.out.println(linkedList);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));            //返回3
    }
}

