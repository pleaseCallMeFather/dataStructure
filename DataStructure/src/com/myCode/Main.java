package com.myCode;

import com.myCode.Array.Array;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        /*Array arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        arr.remove(2);
        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr.toString());*/
       /* ArrayList<String> arrayList = new ArrayList<>();
        arrayList.remove(1);*/

        //System.out.println(arrayList.toString());
       /* Object[] ob = {};
        ob[2] = null;

        int[] i = {};
        i[2] = null;*/

        /*int[] ints = new int[10];
        System.out.println(ints[5]);*/

        /*Object[] objs = new Object[10];
        System.out.println(objs[5]);*/
        /*ArrayList arr = new ArrayList<>();
        arr.add(1);
        Class<?> aClass = arr.get(0).getClass();
        System.out.println(aClass.getTypeName());*/

        /*ArrayList arr = new ArrayList<>();
        System.out.println(arr.get(2)); //index < size 才可以
        arr.add(1);*/

        //泛型不支持基本数据类型
       // Array array = new Array();
       // array.add(new Integer(1));

        /*List arr1 = new ArrayList();arr1.add("hi");
        List<String> arr2 = new ArrayList<>();arr2.add("hi");
        System.out.println(arr1.get(0).getClass().getTypeName());
        System.out.println(arr2.get(0).getClass().getTypeName());*/

       /* Array<Integer> arrs = new Array<>();
        for (int i = 0; i < 10; i++) {
            arrs.addLast(i);
        }
        arrs.addLast(100);
        System.out.println(arrs.toString());*/
       // System.out.println(Integer[].class == Integer[].class);

       // System.out.println((Object)Integer.class == (Object)Object[].class);

        /*Array<Integer> arr = new Array<>(1);
        arr.addLast(1);
        arr.remove(0);
        arr.addLast(1);*/

        //System.out.println(2>>1);
        /*ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.get(0));*/
       /* int[] ints = new int[3];
        int result = ints[-1];*/


        /*Array<Integer> integerArray = new Array<>();
        integerArray.get(-1);
        System.out.println("执行完毕");*/

       // System.out.println(10 >> 1 >> 1);
        int a = 5;
        int x = 5;
        int b = --a;//先减再拿出  4
        int c = x--;//先拿出来再减  5
        System.out.println(b);
        System.out.println(c);

        int d =6;
        int y =6;
        int j = d++;//先拿出来 6
        int k = ++y;//先算再拿 7
        System.out.println(j);
        System.out.println(k);
    }
}
