package com.centsuse.leetcode.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-04-27 23:29
 **/
class Myold {

    private Node head;

    private int size;

    class Node {
        private int val;

        private Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public Myold() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
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

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (null == head) {
            node.next = head;
            head = node;
            size++;
        } else {
            Node tmp = head;
            while (tmp != null) {
                if (tmp.next == null) {
                    tmp.next = node;
                    size++;
                } else {
                    tmp = tmp.next;
                }
            }
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            Node tmp = head;
            Node node = new Node(val);
            if (tmp == null) {
                head = node;
                size++;
            } else {
                int i = 1;
                while (tmp != null) {
                    if (i == index) {
                        node.next = tmp.next;
                        tmp.next = node;
                        size++;
                    } else {
                        tmp = tmp.next;
                        i++;
                    }
                }
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
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
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */