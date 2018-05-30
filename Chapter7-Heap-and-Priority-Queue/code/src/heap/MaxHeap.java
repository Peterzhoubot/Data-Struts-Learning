package heap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MaxHeap
 * @Description ����
 * @Date 18-5-28 ����9:22
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * ����������Ϊ�ѵ�ʵ��
     */
    private Array<E> data;

    /**
     * ֪����ʼ�����Ĺ��캯��
     *
     * @param capacity ��ʼ����������
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * Ĭ���޲ι��캯��
     */
    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * ���ض��и���
     *
     * @return int����
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * �ж϶��Ƿ�Ϊ��
     *
     * @return boolean�Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�صĸ��׽ڵ������
     *
     * @param index ���������ֵ
     * @return ���׽ڵ������
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent!");
        }
        return (index - 1) / 2;
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص����ӽڵ������
     *
     * @param index ���������ֵ
     * @return ���ӽڵ������
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
     *
     * @param index ���������ֵ
     * @return �Һ��ӽڵ������
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * ���в���Ԫ��
     * ʵ��˼·:ͨ����̬����ʵ��,����������ĩβ�����Ԫ��
     * ���ӽڵ�ȸ��ڵ��,�򽻻�λ��
     * if child's Node > parent's Node:
     *     swap(siftUp)
     *
     * @param e Ԫ��
     */
    public void add(E e) {
        data.addLast(e);
        //�������һλ����,��1����Ϊ������0��ʼ
        siftUp(data.getSize() - 1);
    }

    /**
     * �ѵ��ϸ�����,�Ƚϸ�-�ӽڵ�
     * @param i
     */
    private void siftUp(int i) {
        //�����ǰ��������0,�����ӽڵ�ȸ��ڵ��,����н���λ��
        while(i > 0 && data.get(parent(i)).compareTo(data.get(i)) <0){
            data.swap(i,parent(i));
            //������ڵ�С���ӽڵ�,�����ڵ�����λ�ý����ӽڵ�
            i = parent(i);
        }
    }

    /**
     * ȡ���������Ԫ��
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        //1. ����ĩβ��λ��Ԫ�������Ԫ�ؽ���
        data.swap(0, data.getSize() - 1);
        //2. �Ƴ��������Ԫ��
        data.removeLast();
        //3. �������0����Ԫ��sift Down��������
        siftDown(0);
        //���������ʱ�洢��Ԫ��
        return ret;
    }

    /**
     * ���Ҷѵ����Ԫ��,����������Ϊ0��Ԫ��
     *
     * @return
     */
    private E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        //�ѵĵ�һ��Ԫ��
        return data.get(0);
    }


}
