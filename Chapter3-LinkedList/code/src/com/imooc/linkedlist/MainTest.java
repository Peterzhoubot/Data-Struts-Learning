package com.imooc.linkedlist;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description ���������
 * @Date 18-5-3 ����10:11
 */
public class MainTest {

    @Test
    public void testLinkedList(){
        LinkedListQuery<Integer> linkedListQuery = new LinkedListQuery<>();
        for (int i = 0; i < 5; i++) {
            linkedListQuery.addFirst(i);
            System.out.println(linkedListQuery);
        }
        linkedListQuery.add(2,666);
        System.out.println(linkedListQuery);
    }
}
