/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode r = resultHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val + carry;
            r.next = new ListNode(result % 10);
            r = r.next;
            carry = result / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int result = l1.val + carry;
            r.next = new ListNode(result % 10);
            r = r.next;
            carry = result / 10;
            l1 = l1.next;
        }
        while(l2 != null){
            int result = l2.val + carry;
            r.next = new ListNode(result % 10);
            r = r.next;
            carry = result / 10;
            l2 = l2.next;
        }
        if(carry != 0){
            r.next = new ListNode(carry);
        }
        return resultHead.next;
    }
}
// @lc code=end

