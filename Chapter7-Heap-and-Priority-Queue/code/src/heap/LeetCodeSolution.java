package heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName LeetCodeSolution
 * @Description LeetCode 347 ��,ʹ�����ȶ���(�Լ�ʵ�ֵ����ȶ���)�����
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
 * �������� [1,1,1,2,2,3] , �� k = 2������ [1,2]��
 * @Date 2018/6/3 15:23
 */
public class LeetCodeSolution {

    /**
     * ����һ��freq�ڲ���,��װ��key-value��Ϊ��������
     * Ŀ����:��map��key-value����freq������,��ΪPriorityQueue<Freq>�ķ��͡�
     * ע: ������Ҫʵ�ֿɱȽϽӿ�,��ΪPriorityQueue��Ҫ�ɱ���
     */
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        /**
         * Ƶ��ԽС,���ȼ�Խ��
         * Ŀ�����ö�����ֻ��Ƶ������,Ƶ��С�Ķ�������
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * LeetCode������
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //key:Ԫ��,value:Ƶ�ʵĴ���
        TreeMap<Integer, Integer> map = new TreeMap<>();
        /*
         * ������������飬���������ֵ�����value��һ
         * ��û�а���keyֵ,˵���ǵ�һ�δ���,value��Ϊ1
         */
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.getSize() < k){
                queue.enqueue(new Freq(key,map.get(key)));
            }else if (map.get(key) > queue.getHead().freq){
                queue.dequeue();
                queue.enqueue(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        //�����в�Ϊ��,�򵯳����ʣ������е�keyֵ
        while (!queue.isEmpty()){
            res.add(queue.dequeue().e);
        }
        return res;
    }

}
