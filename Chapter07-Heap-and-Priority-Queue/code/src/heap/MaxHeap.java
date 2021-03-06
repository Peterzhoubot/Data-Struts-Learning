package heap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MaxHeap
 * @Description 最大堆
 * @Date 18-5-28 下午9:22
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 引入数组作为堆的实现
     */
    private Array<E> data;

    /**
     * 知道初始容器的构造函数
     *
     * @param capacity 初始化容量因子
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * 默认无参构造函数
     */
    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 添加heapify的方式添加数组数据
     * 原理：从数组最后一个索引位置的元素开始向上遍历,每次进行下沉操作。
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中个数
     *
     * @return int个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return boolean是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引
     *
     * @param index 传入的索引值
     * @return 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hava parent!");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 传入的索引值
     * @return 左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 传入的索引值
     * @return 右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 堆中插入元素
     * 实现思路:通过动态数组实现,向数组索引末尾处添加元素
     * 若子节点比父节点大,则交换位置
     * if child's Node > parent's Node:
     * swap(siftUp)
     * 时间复杂度:O(log n)
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        //数组最后一位索引,减1是因为索引从0开始
        siftUp(data.getSize() - 1);
    }

    /**
     * 堆的上浮方法,比较父-子节点
     *
     * @param i
     */
    private void siftUp(int i) {
        //如果当前索引大于0,并且子节点比父节点大,则进行交换位置
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            //如果父节点小于子节点,将父节点索引位置交给子节点
            i = parent(i);
        }
    }

    /**
     * 取出堆中最大元素
     * 时间复杂度:O(log n)
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        //1. 将最末尾的位置元素与最大元素交换
        data.swap(0, data.getSize() - 1);
        //2. 移除最后的最大元素
        data.removeLast();
        //3. 将换后的0索引元素sift Down到最下面
        siftDown(0);
        //返回最大临时存储的元素
        return ret;
    }

    /**
     * 下沉过程
     * i节点左孩子索引小于总个数(循环一直继续)
     *
     * @param i
     */
    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            /*
             * j + 1 < data.getSize()说明有右孩子
             * j 存的是右孩子索引节点
             */
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            //data[j] 是 leftChild 和 rightChild中的最大值
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(i, j);
            i = j;
        }
    }

    /**
     * 查找堆的最大元素,即数组索引为0的元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        //堆的第一个元素
        return data.get(0);
    }


}
