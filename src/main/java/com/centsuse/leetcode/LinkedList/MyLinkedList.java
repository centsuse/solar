package com.centsuse.leetcode.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-04-26 23:46
 **/
class MyLinkedList {

    Node head;

    int size;

    class Node {
        int val;

        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        /** 如果查询的索引小于等于0或者大于链表长度，返回-1 */
        if (index <= 0 || index > size) {
            return -1;
        } else {
            if (head == null) {
                return -1;
            }
            Node node = head;
            for (int i = 0; node.next != null && i < index; i++) {
                node = node.next;
            }
            return node.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (null == head) {
            head = newTail;
        } else {
            Node lastNode = head;
            while (null != lastNode.next) {
                lastNode = lastNode.next;
            }
            lastNode.next = newTail;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            Node tmp = head;
            for (int i = 0; tmp.next != null && i < index; i++) {
                tmp = tmp.next;
            }
            tmp.next = new Node(val);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index <= 0) {
            return;
        } else if (index > size) {
            return;
        } else {
        }
    }

    public static void main(String[] args) {


//
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
//        System.out.println(myLinkedList.get(3));
//        System.out.println("one: " + myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(1);
//        System.out.println("two: " + myLinkedList.get(1));
//        myLinkedList.addAtTail(1);
//        myLinkedList.addAtTail(2);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtTail(4);
//        myLinkedList.addAtTail(5);
//        System.out.println(myLinkedList.size);
//        System.out.println(myLinkedList.get(1));
//        System.out.println(myLinkedList.get(2));
//        System.out.println(myLinkedList.get(3));
//        System.out.println(myLinkedList.get(4));
//        System.out.println(myLinkedList.get(5));
//        System.out.println("--------after add 3 30----------");
//        myLinkedList.addAtIndex(2, 30);
//        System.out.println(myLinkedList.get(1));
//        System.out.println(myLinkedList.get(2));
//        System.out.println(myLinkedList.get(3));
//        System.out.println(myLinkedList.get(4));
//        System.out.println(myLinkedList.get(5));
//        System.out.println(myLinkedList.get(6));
//
//        System.out.println("--------after del 3 30----------");
//        myLinkedList.deleteAtIndex(3);
//        myLinkedList.deleteAtIndex(2);
//        System.out.println(myLinkedList.get(1));
//        System.out.println(myLinkedList.get(2));
//        System.out.println(myLinkedList.get(3));
//        System.out.println(myLinkedList.get(4));
//        System.out.println(myLinkedList.get(5));
//        System.out.println(myLinkedList.get(6));
    }
}

///**
// * Your MyLinkedList object will be instantiated and called as such:
// * MyLinkedList obj = new MyLinkedList();
// * int param_1 = obj.get(index);
// * obj.addAtHead(val);
// * obj.addAtTail(val);
// * obj.addAtIndex(index,val);
// * obj.deleteAtIndex(index);
// ** /
