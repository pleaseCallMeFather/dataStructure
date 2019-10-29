package com.myCode.Stack;

/**
 * @Author: qdd
 * @Date: 2019/10/28 10:13
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> as = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            as.push(i);
        }
        as.pop();
        System.out.println(as.getCapacity());
        System.out.println(as.getSize());
        System.out.println(as.peek());
        System.out.println(as.isEmpty());
        System.out.println(as.toString());
    }
}
