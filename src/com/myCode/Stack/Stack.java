package com.myCode.Stack;

/**
 * @Author: qdd
 * @Date: 2019/10/24 10:07
 * @Description: 栈
 */
public interface Stack<E> {
    //入栈
    void push(E e);

    //出栈
    E pop();

    //获取栈顶元素
    E peek();

    //长度
    int getSize();

    //判空
    boolean isEmpty();
}
