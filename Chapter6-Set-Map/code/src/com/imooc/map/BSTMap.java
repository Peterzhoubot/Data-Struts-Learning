package com.imooc.map;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BSTMap
 * @Description ���ڶ���������������Map
 * @Date 2018/5/25 22:07
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * �������ڵ�
     */
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * ���ڵ�
     */
    private Node root;
    /**
     * BSTMap��С
     */
    private int size;

    /**
     * ���캯��
     */
    public BSTMap() {
        root = null;
        size = 0;
    }


    @Override
    public void add(K key, V value) {
        //��Ӹ��ڵ�k-vֵ
        root = add(root, key, value);
    }

    /**
     * �������ݹ����K-V����
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            add(node.right, key, value);
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
