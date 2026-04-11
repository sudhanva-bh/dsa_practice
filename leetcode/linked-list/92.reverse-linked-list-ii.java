/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        
        if(left != 1) {
            ListNode l = head;
            for(int i = 0; i < left - 2; i++)
                l = l.next;

            ListNode prev = l, curr = l.next, nxt = l.next.next;
            for(int i = 0; i <= right - left; i++) {
                
            }
        }
    }
}
// @lc code=end

