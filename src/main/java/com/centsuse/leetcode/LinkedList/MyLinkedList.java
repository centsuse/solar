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
//        if (index <= 0 || index > size) {
//            return -1;
//        } else {
//            Node node = head;
//            if (index == 1) {
//                return node.val;
//            } else {
//                int i = 1;
//                while (null != node.next) {
//                    node = node.next;
//                    index--;
//                    if (index == 1) {
//                        return node.val;
//                    }
//                }
//            }
//            return -1;
//        }
        if (index <= 0) {
            return -1;
        } else {
            Node tmp = head;
            int i = 1;
            while (tmp != null) {
                if (i == index) {
                    return tmp.val;
                } else {
                    i++;
                    tmp = tmp.next;
                }
            }
            return -1;
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
            Node p = new Node(val);
            if (head == null) { //空链表
                head = p;
            } else {
                //在链表中间添加新节点
                Node q = head;
                int i = 0;
                while (q != null && i < index - 1) {//获取索引为index-1的节点tempNode
                    q = q.next;
                    i++;
                }
                p.next = q.next;
                q.next = p;
            }
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
            if (null == head) {
                return;
            }
            /** 如果删除第一个，则删除头节点 */
            if (index == 1) {
                head = head.next;
                size--;
                return;
            }
            Node pre = head;
            Node tmp = pre.next;
            int i = 2;
            while (tmp != null) {
                if (i == index) {
                    pre.next = tmp.next;
                    size--;
                } else {
                    pre = pre.next;
                    tmp = pre.next;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {


//
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
        System.out.println("one: " + myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println("two: " + myLinkedList.get(1));
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
