/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode first = head;
        ListNode second = head.next;
        head = second;

        while(true) {
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            first = first.next;
            if(first == null || first.next == null) break;
            second = first.next;
        }

        return head;
    }
}
// @lc code=end

