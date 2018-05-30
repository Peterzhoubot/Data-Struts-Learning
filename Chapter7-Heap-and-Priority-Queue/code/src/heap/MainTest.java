package heap;

import org.junit.Test;

import java.util.Random;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description MaxHeap's Junit Test
 * @Date 2018��05��30��23:02:59
 */
public class MainTest {

    @Test
    public void testMaxHeap() {
        int n = 10000000;
        MaxHeap<Integer> heap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        /*
         * arr��Ӧ���ǴӴ�С����.
         * �������ǰһ��Ԫ��С�ں�һ��Ԫ�ص�ֵ,���׳��쳣��
         */
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("Test MaxHeap completed!");
    }
}
