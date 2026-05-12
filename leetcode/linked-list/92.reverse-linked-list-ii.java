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
        
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode l = temp;
        for(int i = 0; i < left - 1; i++) {
            l = l.next;
        }

        ListNode ln = l.next;

        ListNode prev = null;
        ListNode curr = ln;
        ListNode next = curr.next;

        int size = right - left + 1;
        for(int i = 0; i < size; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        l.next = prev;
        ln.next = curr;

        return temp.next;
    }
}
// @lc code=end

