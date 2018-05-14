package com.imooc.binarysearchtree;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName BinarySearchTreeBasic
 * @Description ����������-���װ�(�ݹ����)
 * @Date 2018/5/11 22:27
 */
public class BinarySearchTreeLevelUp<E extends Comparable<E>> {

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
    public BinarySearchTreeLevelUp() {
        this.root = null;
        this.size = 0;
    }

    /**
     * ��ȡ��������
     *
     * @return ������
     */
    public int getSize() {
        return size;
    }

    /**
     * �ж��Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ��������������������
     *
     * @param e ��ӵ�����
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * ����nodeΪ���Ķ����������в���E,�ݹ��㷨
     * ���ز����½ڵ������������ĸ�
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        //�жϽڵ��Ƿ�Ϊ��,��Ϊ��,�򷵻���Ϊ���ڵ�
        if (node == null) {
            size++;
            return new Node(e);
        }

        //�ٴεݹ����,�������˽�е�������
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * �ж϶����������Ƿ����Ԫ��E
     *
     * @param e ���������
     * @return �Ƿ����
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * ����nodeΪ���Ķ������������Ƿ����Ԫ��e, �ݹ��㷨
     *
     * @param node ��nodeΪ���Ķ���������
     * @param e    ���������
     * @return
     */
    private boolean contains(Node node, E e) {

        //���Ϊ��,����false
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // e.compareTo(node.e) > 0
        else {
            return contains(node.right, e);
        }
    }

    //ǰ�����
    public void preOrder() {
        preOrder(root);
    }

    /**
     * ǰ�������nodeΪ���Ķ������������ݹ��㷨
     * <p>
     * ǰ�����:�ȸ����Ȼ���������������������������
     * <p>
     * ��������Ϊ����������أ�����
     * ��1�����ʸ���㡣
     * ��2��ǰ�������������
     * ��3��ǰ����������� ��
     * ��Ҫע����ǣ�������������ʱ��Ȼ����ǰ�����������
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //�������
    public void midOrder() {
        midOrder(root);
    }

    /**
     * �������
     * ��1���������������
     * ��2�����ʸ����
     * ��3���������������
     * <p>
     * ����:��С��������ı���˳��
     *
     * @param node
     */
    private void midOrder(Node node) {

        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);

    }

    //�������
    public void postOrder() {
        postOrder(root);
    }

    /**
     * ��������Ϊ����������أ�
     * ����
     * ��1���������������
     * ��2���������������
     * ��3�����ʸ����
     * Ӧ��:
     * �����������ͷ��ڴ�
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * ������node Ϊ���ڵ㣬���Ϊdepth�����������������ַ���
     *
     * @param node
     * @param depth
     * @param sb
     */
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
