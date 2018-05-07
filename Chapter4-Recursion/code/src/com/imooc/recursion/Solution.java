package com.imooc.recursion;

/**
 * @author suyu
 * @version 1.0.0
 * @ClassName Solution
 * @Description leetCode ���203��
 * <p>
 * ɾ�������е��ڸ���ֵ val �����нڵ㡣
 * ʾ��:
 * ����: 1->2->6->3->4->5->6, val = 6
 * ���: 1->2->3->4->5
 * @Date 18-5-7 ����10:10
 */

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        //����ڵ㲻Ϊ���ҽڵ��ֵ���ڸ���Ҫɾ����ֵ
        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            //��������������һ��ԭ��
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                //��������������һ��ԭ��
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return head;
    }
}

