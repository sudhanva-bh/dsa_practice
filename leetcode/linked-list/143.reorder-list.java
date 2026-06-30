/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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

    ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode fow = new ListNode();
        ListNode rev = new ListNode();

        ListNode currFow = fow;
        ListNode currRev = rev;

        ListNode curr = head;

        while(curr != null && curr.next != null) {
            currFow.next = curr;
            curr = curr.next;
            
            currRev.next = curr;
            curr = curr.next;

            currFow = currFow.next;
            currRev = currRev.next;
        }

        if(curr != null) {
            currFow.next = curr;
            currFow = currFow.next;
        }

        currFow.next = null;
        currRev.next = null;

        currFow = fow.next;
        currRev = rev.next;

        rev.next = reverse(rev.next);

        ListNode res = new ListNode();
        curr = res;

        while(currFow != null && currRev != null) {
            curr.next = currFow;
            curr = curr.next;
            curr.next = currRev;
            curr = curr.next;

            currFow = currFow.next;
            currRev = currRev.next;
        }

        if(currFow != null) {
            curr.next = currFow;
        }

        if(currRev != null) {
            curr.next = currRev;
        }

        head = res.next;
    }
}
// @lc code=end
