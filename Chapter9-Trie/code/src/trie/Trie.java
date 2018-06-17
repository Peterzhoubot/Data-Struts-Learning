package trie;

import java.util.TreeMap;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Trie
 * @Description Trie ��
 * @Date 2018/6/17 12:27
 */
public class Trie {

    /**
     * �����ڲ���ڵ�
     */
    private class Node {

        /**
         * �Ƿ���һ������
         */
        public boolean isWord;

        /**
         * ��char-node��Ϊӳ��,��trie��ΪӢ�ĵ���,
         * ��Ϊ��ĸ�ĵ�Ԫ��װ��Character
         */
        public TreeMap<Character, Node> next;

    }
}
