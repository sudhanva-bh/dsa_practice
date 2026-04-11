/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
}
*/
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        while(right != null) {
            if(left.val != right.val) {
                left.next = right;
                left = right;
            }
            right = right.next;
        }
        return head;
    }
}
// @lc code=end

