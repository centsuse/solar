package com.centsuse.leetcode.Stack;

import com.centsuse.leetcode.Array.Array;

import java.util.Stack;

/**
 * @author centsuse
 * @DESCRIPTION ${DESCRIPTION}
 * @create 2020-05-20 0:09
 **/
public class ArrayStack<E> implements StackInterface<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    /**
     *
     * @param s
     * @return
     */
    public boolean isVaild(String s) {
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ('{' == c || '[' == c || '(' == c) {
                arrayStack.push(c);
            } else {
                if (arrayStack.isEmpty()) {
                    return false;
                }
                /** 一定先检查为空，防止空指针 */
                Character top = arrayStack.pop();
                if ('}' == c && '{' != top) {
                    return false;
                }
                if (')' == c && '(' != top) {
                    return false;
                }
                if (']' == c && '[' != top) {
                    return false;
                }
            }
        }
        return arrayStack.isEmpty();
    }

//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if ('{' == c || '[' == c || '(' == c) {
//                stack.push(c);
//            } else {
//                if(stack.isEmpty())
//                    return false;
//                Character top = stack.pop();
//                if ('}' == c && '{' != top) {
//                    return false;
//                }
//                if (']' == c && '[' != top) {
//                    return false;
//                }
//                if (')' == c && '(' != top) {
//                    return false;
//                }
//
//            }
//        }
//        return stack.isEmpty();
//    }

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack();
        System.out.println(arrayStack.isVaild("[[[]]]]}"));
        System.out.println(arrayStack.isVaild("(){}[]"));
        System.out.println(arrayStack.isVaild("({{}})"));
        System.out.println(arrayStack.isVaild("[[[]]"));
    }
}
