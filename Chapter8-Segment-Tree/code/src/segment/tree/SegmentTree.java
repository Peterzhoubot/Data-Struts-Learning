package segment.tree;

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

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //����4������
        tree = (E[]) new Object[arr.length * 4];
    }

    /**
     * ��ȡ���Ĵ�С
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * ����������ȡԪ��
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
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }


}
