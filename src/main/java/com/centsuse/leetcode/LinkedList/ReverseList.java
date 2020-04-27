package com.centsuse.leetcode.LinkedList;

// 翻转一个链表 leetcode：206 easy
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-04-25 23:17
 **/
public class ReverseList {

    private static class LinkedNode {
        int value;

        LinkedNode next;

        LinkedNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            LinkedNode tmpNode = this;
            while (null != tmpNode) {
                sb.append(tmpNode.value + ",");
                tmpNode = tmpNode.next;
            }
            sb.append(']');
            return sb.toString();
        }
    }

    private static LinkedNode reverseList(LinkedNode head) {
        LinkedNode preNode = null;
        LinkedNode curNode = head;
        while (null != curNode) {
            LinkedNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    private static LinkedNode reverseListByRecly(LinkedNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        /** head之后的全部反转完毕 */
        LinkedNode p = reverseListByRecly(head.next);
        /** 把head和head之后的进行反转 */
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(1);
        linkedNode.next = new LinkedNode(2);
        linkedNode.next.next = new LinkedNode(3);
//        System.out.println(reverseList(linkedNode));
        System.out.println(reverseListByRecly(linkedNode));
    }
}
