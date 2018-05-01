package com.imooc.linkedlist;
/**
 * @ClassName LinkedList
 * @Description ������Ķ�̬���ݽṹ--����
 * @author suyu
 * @Date 2018/5/1 21:52
 * @version 1.0.0
 */
public class LinkedList<E> {

    /**
     * �˴����Node�ڵ���Ϊ�ڲ��࣬Ŀ�����£�
     * ����д�������ݽṹ�ĵײ���룬���ͻ�ʹ�õ�ʱ�򣬿ͻ������ע�����ݽṹ��ʲô���ԣ�
     * ʹ�õ�ʱ����Ҫ��ע��ô�ü��ɣ�����Node����Ϊ�ڲ��࣬�Կͻ���ʹ�ö��ԣ������εĲ�����
     */
    private class Node{
        /**
         * ���������Ԫ��
         */
        public E e;
        /**
         * ����Ľڵ�ָ��
         */
        public Node next;

        /**
         * �����ݺ�ָ��Ĺ��캯��,�û���������
         * @param e ����Ԫ��e
         * @param next ����ָ��
         */
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * �вι��죬�û�����һ������Ԫ��e
         * @param e ����e
         */
        public Node(E e){
            this(e,null);
        }

        /**
         * Ĭ�ϵĹ��캯�����޲Σ�ֱ�Ӷ���null
         */
        public Node(){
            this(null,null);
        }

    }
}
