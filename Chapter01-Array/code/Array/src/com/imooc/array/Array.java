package com.imooc.array;

/**
 * @author sy
 * @version 1.0.0
 * @ClassName Array（有限制，数组只能放整形）数组篇
 * @Description 慕课实战--数据结构篇
 * @Date 2018/4/21 11:20
 */
public class Array {

    /**
     * 自定义初始化一个int的数组
     */
    private int[] data;
    /**
     * 在data数组中有效的元素个数
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认调用构造函数，给10个大小的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获得数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组最后一位置添加一个元素
     *
     * @param e
     */
    public void addLast(int e) {
        //调用add方法即可，size即是最后一位
        add(size, e);
    }

    /**
     * 向数组第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(int e) {
        //同理调用add即可
        add(0, e);
    }

    /**
     * 按照指定index索引位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed.Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed.Require index =>0 and index <= size .");
        }
        for (int i = size - 1; i >= index; i--) {
            //数组最后一位往后移动，插入节点的每一个都往后移动一位
            data[i + 1] = data[i];
        }
        //将插入的索引位置内容替换为e
        data[index] = e;
        //每次将指针往后移动一格
        size++;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 更新某一索引的字段
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断是否包含某一元素
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素e的索引位置,若存在e则返回，若不存在e则返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除某一索引的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        //将此索引的输出位置返回给用户
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除某个元素
     *
     * @param e
     * @return
     */
    public boolean removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 重写了toString方法，为了打印方便
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d , capacity = %d %n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
