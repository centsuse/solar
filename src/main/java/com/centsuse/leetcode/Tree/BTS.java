package com.centsuse.leetcode.Tree;

import com.centsuse.leetcode.Queue.LoopQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-27 23:37
 **/
public class BTS<E extends Comparable<E>> {

    // 内部类私有属性外部类能访问到吗
    private class Node {
        /**
         * 值
         */
        private E e;

        /**
         * 左孩子
         */
        private Node left;

        /**
         * 右孩子
         */
        private Node right;

        Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        Node() {
            this.e = null;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 二分搜索树的大小
     */
    private int size;

    public BTS(E e) {
        this.root = new Node(e);
        this.size++;
    }

    public BTS() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 遍历插入，遍历到最小二叉树（空节点）插入
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        /** 遍历到当前节点为空，则把节点放在此处 */
        if (null == node) {
            size++;
            return new Node(e);
        }

        /** 如果要插入元素小于当前节点，则插入到当前节点的左子树中 */
        if (e.compareTo(node.e) < 0) {
            /** 如果要插入元素小于当前节点，则插入到当前节点的左子树中 */
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            /** 如果要插入元素小于当前节点，则插入到当前节点的左子树中 */
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 使用非递归的方式添加节点
     * @param e
     */
    public void addNR(E e) {
        /** 如果树为空，则添加元素为根节点 */
        if (null == root) {
            root = new Node(e);
        }
        Node curNode = root;
        /** 只有当该元素小于节点且左节点为空或者大于该节点且右节点为空，可插入 */
        while (!(null == curNode.left && e.compareTo(curNode.e) < 0 || null == curNode.right && e.compareTo(curNode.e) > 0)) {
            if (e.compareTo(curNode.e) == 0) {
                return;
            } else if (e.compareTo(curNode.e) < 0) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        if (null == curNode.left && e.compareTo(curNode.e) < 0) {
            curNode.left = new Node(e);
        } else {
            curNode.right = new Node(e);
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 递归实现前序遍历：先节点再左右孩子，中左右
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 使用非递归的方式前序遍历：中左右
     * 根节点入栈，弹出，弹出后右左孩子节点入栈，下一节点弹出，该节点右左孩子节点入栈
     */
    public void preOrderNR() {

        if (null == root) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历：先左孩子节点，在本节点，再右孩子节点，左中右
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // TODO 中续遍历非递归写法


    /**
     * 后序遍历，先左节点，右节点，再本节点，左右中
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // TODO 后续遍历非递归写法

    /**
     * 层序遍历（广度优先遍历）
     * 使用队列，根节点进队，根节点出队，左右孩子入队，左孩子出队，左孩子左右节点入队，右孩子出队，右孩子左右节点入队...
     */
    public void leverOrder() {
        if (null == root) {
            return;
        }
        LoopQueue<Node> queue = new LoopQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node.e);
            if (null != node.left) {
                queue.enqueue(node.left);
            }

            if (null != node.right) {
                queue.enqueue(node.right);
            }
        }
    }

    /**
     * 获取最小节点的数据值
     * @return
     */
    public Node getMinElement() {
        if (null == root) {
            return null;
        }
        return getMinElement(root);
    }

    private Node getMinElement(Node node) {
        if (null == node.left) {
            return node;
        }
        return getMinElement(node.left);
    }

    /**
     * 获取最大节点的数据值
     * @return
     */
    public Node getMaxElement() {
        if (null == root) {
            return null;
        }
        return getMaxElement(root);
    }

    private Node getMaxElement(Node node) {
        if (null == node.right) {
            return node;
        }
        return getMaxElement(node.right);
    }

    /**
     * 移除bts中最小元素的节点，并返回该节点
     * @return
     */
    public Node removeMinElement() {
        if (null == root) {
            return null;
        }
        Node node = getMinElement();
        root = removeMinElement(root);
        return node;
    }

    private Node removeMinElement(Node node) {
        if (null == node.left) {
            Node newNode = node.right;
            node = null;
            size--;
            return newNode;
        }
        node.left = removeMinElement(node.left);
        return node;
    }

    /**
     * 移除bts中最大数据的元素，并返回删除的节点
     * @return
     */
    public Node removeMaxElement() {
        if (null == root) {
            return null;
        }
        Node node = getMaxElement();
        root = removeMaxElement(root);
        return node;
    }

    private Node removeMaxElement(Node node) {
        if (null == node.right) {
            Node newNode = node.left;
            node = null;
            size--;
            return newNode;
        }
        node.right = removeMaxElement(node.right);
        return node;
    }

    /**
     * 删除树中任一元素
     * @return
     */
    public void removeElement(E e) {
        if (null == root || null == e) {
            throw new IllegalArgumentException("error root or e");
        }
        root = removeElement(root, e);
    }

    private Node removeElement(Node node, E e) {
        if (null == node) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = removeElement(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = removeElement(node.right, e);
            return node;
        } else {
            // 如果节点的左子树为空，则把节点的右子树放到该位置
            if (null == node.left) {
                Node rightNode = node.right;
                node = null;
                size--;
                return rightNode;
            } else if (null == node.right) {
                Node leftNode = node.left;
                node = null;
                size--;
                return leftNode;
            } else {
                // 左右子树都不为null，从node的子树中找出比node大的最小的元素（后继）
                Node successor = new Node(getMaxElement(node.right).e);
                successor.left = node.left;
                successor.right = removeMinElement(node.right); // 元素删除在该位置进行，size--
                node.left = node.right = null;
                return successor;
            }

        }
    }


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
//        map.containsKey()
        int[] a = new int[]{1, 2};
        BTS<Integer> bts = new BTS<>();
        bts.addNR(10);
        bts.addNR(12);
        bts.addNR(23);
        bts.addNR(45);
//        System.out.println(bts.contains(10));
//        System.out.println(bts.contains(12));
//        System.out.println(bts.contains(23));
//        System.out.println(bts.contains(45));
//        System.out.println("\n");
        System.out.println("preOrder:");
        bts.preOrder(); // 10, 12, 23, 45
        System.out.println("------------------");
        System.out.println("preOrderNR: ");
        bts.preOrderNR();
        bts.addNR(1);
//        System.out.println("-----------------");
//        System.out.println(bts.contains(90));
//        System.out.println(bts.contains(1));
        System.out.println("\n");
        System.out.println("------------------");
        bts.preOrder(); // 10, 1, 12, 23, 45
        System.out.println("------------------");
        System.out.println("preOrderNR: ");
        bts.preOrderNR();
        System.out.println("\n");
        System.out.println("leverOrder: ");
        bts.addNR(2);
        bts.addNR(5);
        bts.add(4);
        bts.leverOrder(); // 10, 1, 12, 2, 23, 5, 45, 4
        System.out.println("-----------------------------");
        System.out.println(bts.getMinElement().e); // 1
        System.out.println(bts.getMaxElement().e); // 45
        System.out.println(bts.removeMinElement().e); // 1
        System.out.println("--");
        bts.leverOrder();// 10 2 12 5 23 4 45
        System.out.println("---");
        System.out.println(bts.removeMaxElement().e); // 45
        System.out.println("---");
        bts.leverOrder(); // 10 2 12 5 23 4

        System.out.println("=================");

        BTS<Integer> integerBTS = new BTS<>();
        integerBTS.addNR(10);
        integerBTS.addNR(8);
        integerBTS.addNR(15);
        integerBTS.addNR(6);
        integerBTS.addNR(9);
        integerBTS.addNR(12);
        integerBTS.addNR(17);
//        integerBTS.preOrder(); // 10 8 6 9 15 12 17
//        integerBTS.inOrder(); // 6 8 9 10 12 15 17
//        integerBTS.postOrder(); // 6 9 8 12 17 15 10
//        integerBTS.leverOrder(); // 10 8 15 6 9 12 17
//        integerBTS.removeMaxElement();
//        integerBTS.leverOrder(); // 10 8 15 6 9 12
//        integerBTS.removeMinElement();
//        integerBTS.leverOrder(); // 10 8 15 9 12
//        System.out.println("inOrder:");
//        integerBTS.removeElement(15);
//        integerBTS.leverOrder(); // 10 8 17 6 9 12
        integerBTS.removeElement(8);
        integerBTS.leverOrder(); // 10 9 15 6 12 17
        integerBTS.removeElement(17);
        integerBTS.leverOrder(); // 10 9 15 6 12
//        bts.inOrder(); //1, 10, 12, 23, 45
//        bts.add(11);
//        System.out.println("-----------------");
//        bts.inOrder(); // 1, 10, 11, 12, 23, 45
//        System.out.println("\n");
//        System.out.println("postOrder:");
//        bts.postOrder(); // 1, 11, 45, 23, 12, 10
//        bts.addNR(2);
//        System.out.println("-----------------");
//        bts.postOrder(); // 2, 1, 11, 45, 23, 12, 10
    }
}
