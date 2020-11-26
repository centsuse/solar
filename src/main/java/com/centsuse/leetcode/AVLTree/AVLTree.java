package com.centsuse.leetcode.AVLTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author centsuse
 * @DESCRIPTION
 * @create 2020-07-18 22:06
 **/
public class AVLTree<K extends Comparable<K>, V> {

    private Node root;

    private int size;

    class Node {
        Node left;
        Node right;
        K key;
        V value;
        int height;

        Node(K key, V value) {
            left = null;
            right = null;
            this.key = key;
            this.value = value;
            height = 1;
        }
    }

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        if (null == key) {
            return;
        }

        root = add(root, key, value);
    }

    private int getHeight(Node node) {
        if (null == node) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (null == node) {
            return 0;
        }
        return getBalance(node.left) - getBalance(node.right);
    }

    private boolean isBST(Node node) {
        if (null == node) {
            return true;
        }
        List<K> keys = new ArrayList<>(size);
        inOrder(node, keys);
        for (int i = 0; i < size - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isAVLTree(Node node) {
        if (null == node) {
            return true;
        }
        if (Math.abs(getBalance(node)) > 1) {
            return false;
        }
        return isAVLTree(node.left) && isAVLTree(node.right);
    }

    public boolean isAVLTree() {
        return isAVLTree(root);
    }

    public boolean isBST() {
        return isBST(root);
    }

    private void inOrder(Node node, List<K> keys) {
        if (null == node) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private Node add(Node node, K key, V value) {
        if (null == node) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.left = add(node.left, key, value);
        }
        return flashHeightAndrotate(node);
    }

    private Node flashHeightAndrotate(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int nodeBalance = getBalance(node);

        // LL, 右旋
        if (nodeBalance > 1 && getBalance(node.left) >= 0) {
            node = rightRotate(node);
        }

        // RR, 左旋
        if (nodeBalance < -1 && getBalance(node.right) <= 0) {
            node = leftRotate(node);
        }

        // LR, 先对右子树左旋，再对节点右旋
        if (nodeBalance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
        }

        // RL, 先对左子树右旋，再对节点左旋
        if (nodeBalance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = 1 + Math.abs(getHeight(node.left) + getHeight(node.right));
        left.height = 1 + Math.abs(getHeight(left.left) + getHeight(left.right));
        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = 1 + Math.abs(getHeight(node.left) + getHeight(node.right));
        right.height = 1 + Math.abs(getHeight(right.left) + getHeight(right.right));
        return right;
    }

    public boolean isContains(K key) {
        return isContains(root, key);
    }

    private boolean isContains(Node node, K key) {
        if (null == key || null == node) {
            return false;
        }
        if (key.compareTo(node.key) > 0) {
            return isContains(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return isContains(node.left, key);
        }
        return true;
    }

    public void remove(K key) {
        if (null == key) {
            return;
        }
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (null == node) {
            return null;
        }
        Node tmp = null;
        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            tmp = node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            tmp = node;
        } else {
            if (null == root.left) {
                size--;
                tmp = root.right;
            } else if (null == root.right) {
                size--;
                tmp = root.left;
            } else {
                tmp = getMinElement(node.right);
                tmp.right = remove(node.right, tmp.key);
                tmp.left = node.left;
                node.left = node.right = null;
            }
        }
        return flashHeightAndrotate(tmp);

    }

    private Node getMinElement(Node node) {
        Node tmp = node;
        while (null != tmp) {
            if (null == tmp.left) {
                return tmp;
            } else {
                tmp = tmp.left;
            }
        }
        return tmp;
    }

    private Node getNode(K key) {
        if (null == key) {
            return null;
        }
        Node node = root;
        while (!((key.compareTo(node.key) < 0 && null == node.left) || (key.compareTo(node.key) > 0 && null == node.right))) {
            if (key.compareTo(node.key) == 0) {
                return node;
            } else if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public V get(K key) {
        Node node = getNode(key);
        if (null != node) {
            return node.value;
        }
        return null;
    }

    public void set(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            return;
        }
        node.value = value;
    }

    public static void main(String[] args) {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        avlTree.add(1, 1);
        avlTree.add(2, 2);
        avlTree.add(3, 3);
        avlTree.add(4, 4);
        avlTree.add(5, 5);
        avlTree.add(6, 6);
        System.out.println(avlTree.isBST(avlTree.root));
        System.out.println(avlTree.isAVLTree(avlTree.root));
    }

}
