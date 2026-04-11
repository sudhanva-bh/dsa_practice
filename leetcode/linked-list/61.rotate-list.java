/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode curr = head;
        int n = 0;

        while(curr != null) {
            curr = curr.next;
            n++;
        }

        k %= n;
        if(k == 0) return head;

        ListNode back = head, front = head;

        for(int i = 0; i < k; i++) {
            front = front.next;
        }

        while(front.next != null) {
            front = front.next;
            back = back.next;
        }

        ListNode res = back.next;
        back.next = null;

        front.next = head;

        return res;
    }
}
// @lc code=end

