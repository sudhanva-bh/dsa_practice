/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start

import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        pQueue.addAll(Arrays.asList(lists));

        ListNode head = new ListNode();
        ListNode curr = head;

        while(!pQueue.isEmpty()) {
            ListNode top = pQueue.remove();
            if(top.next != null) pQueue.add(top.next);

            curr.next = top;
            curr = curr.next;
        }

        return head.next;
    }
}
// @lc code=end

