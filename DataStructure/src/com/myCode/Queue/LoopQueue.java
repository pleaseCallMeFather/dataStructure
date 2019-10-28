package com.myCode.Queue;

/**
 * @Author: qdd
 * @Date: 2019/10/28 15:12
 * @Description: 循环队列
 */
public class LoopQueue<E> implements Queue<E> {
    E[] data;
    int front, tail;
    int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; //浪费了一个空间需要补上，这样可用空间才是capacity
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        //判断是否进行扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Can not dequeue because of empty queue");
        }

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        if (--size == (getCapacity() >> 1 >> 1) && getCapacity() >> 1 !=0) {
            resize(getCapacity() >> 1);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Can not getFront because of empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    public int getCapacity() {
        return data.length - 1; //需要浪費一个空间
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: capacity=%d ,size =%d\n",getCapacity(),getSize()));
        sb.append("Front[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(i + front) % data.length] + ",");
        }
        StringBuilder result = new StringBuilder(sb.substring(0, sb.length() - 1)).append("]tail");
        return result.toString();
    }
}
