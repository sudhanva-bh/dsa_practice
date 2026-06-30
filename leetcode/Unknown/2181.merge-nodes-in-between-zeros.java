/*
 * @lc app=leetcode id=2181 lang=java
 *
 * [2181] Merge Nodes in Between Zeros
 */

// @lc code=start
/**
 * // Definition for singly-linked list.
 */
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode last = head;
        int sum = 0;

        ListNode resHead = new ListNode();
        ListNode resCurr = resHead;

        while(last.next != null) {
            sum += last.val;
            last = last.next;
            if(last.val == 0) {
                resCurr.next = first;
                first.val = sum;
                first.next = null;
                resCurr = resCurr.next;

                first = last;
                sum = 0;
            }
        }

        return resHead.next;
    }
}
// @lc code=end
