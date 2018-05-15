package com.imooc.binarysearchtree;

import org.junit.Test;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName MainTest
 * @Description �����������Ĳ�����
 * @Date 2018/5/13 19:52
 */
public class MainTest {

    @Test
    public void testOrder() {
        BinarySearchTreeLevelUp<Integer> bst = new BinarySearchTreeLevelUp<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        //��Ӷ���������ʱ,Ӧ�����½ṹ���
        ///////////////////
        //       5       //
        //     /  \      //
        //    3    6     //
        //   / \    \    //
        //  2  4     8   //
        ///////////////////
        //ǰ��������ṹ
        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        //�ǵݹ�������ṹ(������ȱ���)
        bst.preOrderNR();
        System.out.println();

        //��α���(������ȱ���)
        bst.levelOrder();
        System.out.println();

        //�������
        bst.midOrder();
        System.out.println();

        //�������
        bst.postOrder();
        System.out.println();



    }
}
