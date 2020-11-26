package com.centsuse.leetcode;

/**
 * @author centsuse
 * @DESCRIPTION
 * @create 2020-07-18 23:27
 **/
import com.centsuse.leetcode.AVLTree.AVLTree;
import com.centsuse.leetcode.Tree.BTS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    static {
        i = 10;
//        System.out.println(i);
        if (true) {
            while (true) {
                try {
                    System.out.println("init");
                    Thread.sleep(5000);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("waiting");
        }
    }

    static int i;


    public static void main(String[] args) {
//        AtomicInteger
//        AtomicIntegerFieldUpdater
        Stack stack = new Stack();
//        Thread
//        ThreadLocal
        stack.empty();
        ExecutorService service = new ThreadPoolExecutor(5, 10,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println(i);

        Runnable script = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                Main dlc = new Main();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();

//        System.out.println("Pride and Prejudice");
//
//        ArrayList<String> words = new ArrayList<>();
//        if(FileOperator.readFile("pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
//
//            // Collections.sort(words);
//
//            // Test BST
//            long startTime = System.nanoTime();
//            long endTime = 0l;
//            double time = 0;
//
//            AVLTree<String, Integer> avl = new AVLTree<>();
//            for (String word : words) {
//                if (avl.isContains(word))
//                    avl.set(word, avl.get(word) + 1);
//                else
//                    avl.add(word, 1);
//            }
//            System.out.println(avl.getSize());
//            System.out.println(avl.isAVLTree());
//            System.out.println(avl.isBST());
//
//            for(String word: words)
//                avl.isContains(word);
//
//            avl.remove("I");
//            System.out.println(avl.getSize());
//            System.out.println(avl.isAVLTree());
//            System.out.println(avl.isBST());
//
//            endTime = System.nanoTime();
//
//            time = (endTime - startTime) / 1000000000.0;
//            System.out.println("AVL: " + time + " s");
//        }
//        System.out.println();
    }
}
