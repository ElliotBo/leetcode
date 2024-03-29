package com.elliotzb.leetcode.bfsdfs;

public class N2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int jinwei = 0;
        while (null != l1 || null != l2) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + jinwei;
            jinwei = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (1 == jinwei)
            cur.next = new ListNode(jinwei);
        return pre.next;
    }
}
