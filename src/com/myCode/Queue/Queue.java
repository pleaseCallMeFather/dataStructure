package com.myCode.Queue;

/**
 * @Author: qdd
 * @Date: 2019/10/28 14:49
 * @Description:
 */
public interface Queue<E> {
    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //获取队首
    E getFront();

    //元素个数
    int getSize();

    //判空
    boolean isEmpty();
}
