/*
 * @lc app=leetcode id=2807 lang=java
 *
 * [2807] Insert Greatest Common Divisors in Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
import java.util.*;

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
    int gcd(int a, int b) {
        int rem;
        while (b != 0) {
            rem = a % b;
            a = b;
            b = rem;
        }

        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = first;

        while (first != null && first.next != null) {
            second = first.next;
            first.next = new ListNode(gcd(first.val, second.val), second);

            first = second.next;
        }

        return head;
    }
}
// @lc code=end
