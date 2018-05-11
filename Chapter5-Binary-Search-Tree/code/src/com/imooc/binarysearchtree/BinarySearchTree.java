package com.imooc.binarysearchtree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTree
 * @Description ����������
 * @Date 2018/5/11 22:27
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        /**
         * ���ڵ�Ĵ洢Ԫ��
         */
        public E e;
        /**
         * ������,������
         */
        public Node left, right;


        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * ���ĸ��ڵ�
     */
    private Node root;

    /**
     * ��������
     */
    private int size;

    /**
     * ��ʼ������������
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * ��ȡ��������
     * @return ������
     */
    public int getSize(){
        return size;
    }

    /**
     * �ж��Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


}
