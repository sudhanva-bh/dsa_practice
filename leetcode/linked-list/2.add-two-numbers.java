/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
*/
@SuppressWarnings("unused")
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

@SuppressWarnings("unused")
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        int carry = 0, sum;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            curr.next = l1;
            curr = curr.next;

            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            sum = l1.val + carry;
            l1.val = sum % 10;
            curr.next = l1;
            curr = curr.next;

            carry = sum / 10;

            l1 = l1.next;
        }

        while(l2 != null) {
            sum = l2.val + carry;
            l2.val = sum % 10;
            curr.next = l2;
            curr = curr.next;

            carry = sum / 10;

            l2 = l2.next;
        }

        if(carry != 0) {
            curr.next = new ListNode(carry);
        } else {
            curr.next = null;
        }

        return head.next;
    }
}
// @lc code=end

