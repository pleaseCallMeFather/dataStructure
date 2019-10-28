package com.myCode.Queue;

import com.myCode.Array.Array;

/**
 * @Author: qdd
 * @Date: 2019/10/28 14:52
 * @Description: 数组队列
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> arr;

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }

    public ArrayQueue() {
        arr = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        arr.addLast(e);
    }

    //时间复杂度为:O(n)  优化使用循环队列
    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.getFirst();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("Front[");
        for (int i = 0; i < arr.getSize(); i++) {
            sb.append(arr.get(i) + ",");
        }
        StringBuilder result = new StringBuilder(sb.substring(0, sb.length() - 1)).append("]tail");
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("After dequeuq >>>" + queue);
            }
        }

    }
}
