
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);

        ListNode currentOdd = oddHead;
        ListNode currentEven = evenHead;

        while (current != null && current.next != null) {
            currentOdd.next = current;
            currentEven.next = current.next;
            current = current.next.next;
            currentOdd = currentOdd.next;
            currentEven = currentEven.next;
            currentEven.next = null;
        }

        if (current != null) {
            currentOdd.next = current;
            currentOdd = currentOdd.next;
        }
        currentOdd.next = evenHead.next;
        return oddHead.next;
    }

    public static void printList(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            // Cycle detected
            if (visited.contains(curr)) {
                System.out.print(curr.val + " -> (cycle detected back here)");
                break;
            }

            System.out.print(curr.val + " -> ");
            visited.add(curr);
            curr = curr.next;
        }

        if (curr == null) {
            System.out.print("null");
        }
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 1, 3, 5, 6, 4};
        ListNode head = arrayToList(arr);
        printList(head);
        System.out.println("\n\n\n\n\n");
        printList(sol.oddEvenList(head));
    }
}
// @lc code=end

