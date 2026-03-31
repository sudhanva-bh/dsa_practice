/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare.next != null && hare.next.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise) return true;
        }
        return false;
    }
}
// @lc code=end

