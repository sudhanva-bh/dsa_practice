/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode midPlus = reverse(slow.next);

        while (midPlus != null) {
            if (midPlus.val != head.val) {
                return false;
            }
            midPlus = midPlus.next;
            head = head.next;
        }
        return true; 
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return head;
    }
}
// @lc code=end

