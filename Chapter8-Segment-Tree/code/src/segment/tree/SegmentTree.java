package segment.tree;

import java.util.Arrays;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName SegmentTree
 * @Description �߶����Ļ���ʵ��
 * @Date 18-6-5 ����9:37
 */
public class SegmentTree<E> {

    /**
     * ��ʼ������tree
     */
    private E[] tree;

    /**
     * ��ʼ������
     */
    private E[] data;

    /**
     * ��ʼ�ں���
     */
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {

        //��ʼ���ں���
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //����4������
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * �����߶����ķ���
     * ��treeIndex��λ��,����[l....r]����
     *
     * @param treeIndex �߶����ĸ��ڵ�
     * @param l         �����������
     * @param r         �����������
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {

        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        //����������������
        int leftTreeIndex = this.leftChild(treeIndex);
        //�����Һ�����������
        int rightTreeIndex = this.rightChild(treeIndex);

        /*
         * �˴���д (l + r)/2 ��ԭ����:
         *  ������̫�����������,����д�����д�������м�ֵ��һ����.
         */
        int mid = l + (r - l) / 2;
        //�������߶� ����
        buildSegmentTree(leftTreeIndex, l, mid);
        //�������߶� ����
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //�ۺ����������߶���Ϣ,�õ�����߶���Ϣ
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    /**
     * ��ȡ���Ĵ�С
     *
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * ����������ȡԪ��
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal!");
        }
        return data[index];
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص����ӽڵ������
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                stringBuilder.append(tree[i]);
            } else {
                stringBuilder.append("null");
            }
            if (i != tree.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
