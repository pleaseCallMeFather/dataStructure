package com.myCode.Queue;

/**
 * @Author: qdd
 * @Date: 2019/10/28 17:10
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        /*LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.enqueue(11);

        //queue.enqueue(10);
        System.out.println(queue);*/
        /*long start = System.currentTimeMillis();
        LoopQueue<Integer> loopQueuequeue = new LoopQueue<>();
        for (int i = 0; i < 1000000; i++) {
            loopQueuequeue.enqueue(i);
        }
        for (int i = 0; i < loopQueuequeue.size; i++) {
            loopQueuequeue.dequeue();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);*/

        long start = System.currentTimeMillis();
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 1000000; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < queue.getSize(); i++) {
           queue.dequeue();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
