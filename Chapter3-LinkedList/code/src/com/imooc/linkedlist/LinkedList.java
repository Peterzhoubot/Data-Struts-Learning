package com.imooc.linkedlist;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LinkedList
 * @Description 最基础的动态数据结构--链表
 * @Date 2018/5/1 21:52
 */
public class LinkedList<E> {

    /**
     * 此处设计Node节点类为内部类，目的如下：
     * 我们写的是数据结构的底层代码，给客户使用的时候，客户无需关注此数据结构有什么属性，
     * 使用的时候需要关注怎么用即可，所以Node设置为内部类，对客户端使用而言，是屏蔽的操作。
     */
    private class Node {
        /**
         * 链表的数据元素
         */
        public E e;
        /**
         * 链表的节点指向
         */
        public Node next;

        /**
         * 带数据和指针的构造函数,用户传进来的
         *
         * @param e    数据元素e
         * @param next 链表指针
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * 有参构造，用户传入一个数据元素e
         *
         * @param e 数据e
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * 默认的构造函数，无参，直接都传null
         */
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 头结点指针
     */
    private Node head;
    /**
     * 链表的大小
     */
    private int size;

    public LinkedList() {
        //初始化头指针为空,大小为0
        head = null;
        size = 0;
    }

    /**
     * 获取链表的大小
     *
     * @return 返回链表大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表头部新增节点
     *
     * @param e 新增元素
     */
    public void addFirst(E e) {
        //在头部新增一个
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //优雅的写法,一句等于上面三句
        head = new Node(e, head);
        //维护一下size
        size++;
    }

    /**
     * 链表中间插入的元素
     *
     * @param index "索引",所谓的索引并不是真索引,方便定义而已
     * @param e     添加的数据元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            //1.假设要插入的元素node名字为prev,并且从链表头进行初始化
            Node prev = head;
            //2.循环遍历,确定prev的next的指向位置
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            //3.将插入的node.next指向prev的next
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            //优雅的写法:与addFirst中一样,上面三行的注释
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /**
     * 链表最后添加元素
     * @param e 数据元素
     */
    public void addLast(E e){
        add(size,e);
    }
}
