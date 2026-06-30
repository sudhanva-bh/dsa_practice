/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

// @lc code=start
import java.util.*;

/**
 * Definition for singly-linked list.
 */
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = new ListNode(-200, head);

        ListNode prevNonDup = temp;
        ListNode l = head;
        ListNode r = head;

        while (r != null) {
            while (r != null && r.val == l.val) {
                r = r.next;
            }

            if(l.next == r) {
                prevNonDup = l;
            } else {
                prevNonDup.next = r;
            }
            
            l = r;
        }

        return temp.next;
    }
}
// @lc code=end
