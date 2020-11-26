package com.centsuse.leetcode.LinkedList;

/**
 * @author centsuse
 * @DESCRIPTION 习题: 移除链表元素
 * @create 2020-05-25 22:36
 **/
public class Leetcode {

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ListNode: [");
            ListNode node = this;
            while (null != node) {
                sb.append(node.val);
                sb.append(",");
                node = node.next;
            }
            sb.append("]");
            return sb.toString();
        }

    }

    public static ListNode createNode(int[] nums) {
        if (null == nums) {
            throw new IllegalArgumentException("nums is null");
        }
        ListNode node = new ListNode(nums[0]);
        ListNode returnNode = node;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        System.out.println(returnNode);
        return returnNode;
    }

    /**
     * 普通遍历方法实现
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 添加虚拟头结点，方便统一处理
        ListNode demmyHead = new ListNode(-1);
        demmyHead.next = head;
        ListNode curNode = demmyHead;
        while (null != curNode.next) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return demmyHead.next;
    }
//
//    public ListNode removeElements_their(ListNode head, int val) {
//
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode prev = dummyHead;
//        while(prev.next != null){
//            if(prev.next.val == val)
//                prev.next = prev.next.next;
//            else
//                prev = prev.next;
//        }
//
//        return dummyHead.next;
//    }

    public ListNode removeElements_2(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void removeMidElement(ListNode node) {
        if (null == node || null == node.next || null == node.next.next) {
            return;
        }
        System.out.println(node);
        ListNode preNode = null;

        // TODO
        ListNode curNode = node;

        while (null != curNode.next.next) {
            preNode = curNode;
            curNode = curNode.next.next;
        }

        preNode.next = preNode.next.next;
        System.out.println(node);
    }

    public static void main(String[] args) {
        removeMidElement(createNode(new int[]{1, 2, 4}));
    }

}
