/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        boolean shouldMove = true;
        ListNode middle = head;
        ListNode transversing = head;
        while(transversing.next != null){
            transversing = transversing.next;
            if(shouldMove) middle = middle.next;
            shouldMove = !shouldMove;
        }
        return middle;
    }
}
// @lc code=end

