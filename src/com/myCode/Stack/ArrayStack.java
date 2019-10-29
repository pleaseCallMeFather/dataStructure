package com.myCode.Stack;

import com.myCode.Array.Array;

/**
 * @Author: qdd
 * @Date: 2019/10/24 10:06
 * @Description: 栈的底层是数组
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> arr;

    public ArrayStack(int capacity) {
        arr = new Array<E>(capacity);
    }

    public ArrayStack() {
        arr = new Array<E>();
    }

    //O(1)
    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    //O(1)
    @Override
    public E pop() {
       return arr.removeLast();
    }

    //O(1)
    @Override
    public E peek() {
        return arr.getLast();
    }

    //O(1)
    @Override
    public int getSize() {
        return arr.getSize();
    }

    //O(1)
    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    //O(1)
    public int getCapacity(){
        return arr.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = 0; i < arr.getSize(); i++) {
            sb.append(arr.get(i)+",");
        }
        StringBuilder result = new StringBuilder(sb.toString().substring(0, sb.length() - 1))
                .append("]top");
        return result.toString();
    }
}
