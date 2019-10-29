package com.myCode.Array;


/**
 * @Author: qdd
 * @Date: 2019/10/24 10:10
 * @Description: 动态数组
 */
public class Array<E> {
    private E[] data;  //底层存放数据的是数组
    private int size;    //元素个数

    //自定义初始化容量来构造
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造初始化容量为10
    public Array() {
        data = (E[]) new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向数组末尾添加一个元素
    public void addLast(E e) {
       /* if(size == data.length){
            //如果本次添加元素的时候发现，数组已经被装满了，就要抛出异常
            throw new IllegalArgumentException("Add Failed,Array is full!");
        }
        data[size] = e;
        size++;*/

        //v2版本为调用add插入元素方法向数组下一个空位置插入了一个元素【复用代码】
        add(size, e); //索引从0开始，而元素个数从1开始的
    }

    //向数组头部添加一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    //插入元素方法
    public void add(int index, E e) {
        //进行扩容判断
        ensureCapacityInternal(size + 1);  // Increments modCount!!

        if (index < 0 || index > size) { //插入的索引位置必须在[0,size]之间
            throw new IllegalArgumentException("Add failed,requred index must between 0 and size");
        }

        //插入元素的位置及该位置上的元素向后挪动一位
        //原来：0 1 2 3 5 6 7   现在要插入一个索引为4的位置
        //后来：0 1 2 3   5 6 7 要挪动的元素有（size - index）个
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i]; //把原来位置上的元素赋值给原来位置+1的位置上面就完成了移动啦
        }
        data[index] = e;
        size++;
    }

    //进行扩容缩容
    private void ensureCapacityInternal(int mincapacity) {
        int oldCapacity = data.length;
        int newCapacity = data.length + (data.length >> 1); //变成原容量的1.5倍   //这里一定要加上小括号哦
        if (oldCapacity - mincapacity < 0) {
            E[] newArray = (E[]) new Object[newCapacity];
            //把原数组中的数据拷贝到容量为newCapacity的新数组中
            System.arraycopy(data, 0, newArray, 0, size);
            data = newArray;
        }
    }

    //获取索引对应的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, Index is illegal.");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        //不要data[size -1] 因为data[-1]不合法
        return get(size - 1);
    }

    //修改某个位置的索引元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, Index is illegal.");
        }
        data[index] = e;
    }

    //是否包含元素e,返回索引
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找元素e在索引中的位置
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //移除某个索引位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, Index is illegal.");
        }

        //--------------------------------------------------------------------
        //0 1 2 3 4 5 删除索引为2上的元素，该索引后面的所有元素向前挪动一个位置
        //0 1 3 4 5
        //移除index上位置的元素，首先确定移动的数组范围（index,size) ,循环遍历这个范围的元素，把i赋值给i-1就完成了
        E result = data[index];
        //v1
        /*for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size] = null;  // clear to let GC do its work   如果不用这个，下一个新增的元素会覆盖它
        size--;*/

        //----------------------------------------------------------------------
        //v2 要挪动的元素个数为size - index -1
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;

        //缩容优化  如果data.length=1,移除完一个元素后size = 0,缩容后数组的容量为0 下次add就会出问题
        if (size == (data.length >> 1 >> 1) && data.length != 1) {
            ensureCapacityInternal(data.length >> 1);
        }

        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //这段代码对于有重复元素，只会删除索引最小的那个
    public void removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            remove(index);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size= %d ,capacity =%d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i] + ",");
        }
        return sb.toString()
                .substring(0, sb.length() - 1)
                + "]";
    }
}
