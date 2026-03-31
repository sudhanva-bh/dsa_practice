
class Solution {

    ListNode sortList(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;

        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);

        return mergeLists(firstHalf, secondHalf);
    }

    ListNode mergeLists(ListNode node1, ListNode node2) {

        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                dummy.next = node1;
                dummy = dummy.next;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                dummy = dummy.next;
                node2 = node2.next;
            }
        }

        while (node1 != null) {
            dummy.next = node1;
            dummy = dummy.next;
            node1 = node1.next;
        }

        while (node2 != null) {
            dummy.next = node2;
            dummy = dummy.next;
            node2 = node2.next;
        }

        return result.next;
    }

    static ListNode arrayToLinkedList(int[] arr) {
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

    // static void printLinkedList(ListNode head) {
    //     ListNode curr = head;
    //     while (curr != null) {
    //         System.out.print(curr.val);
    //         if (curr.next != null) {
    //             System.out.print(" -> ");
    //         }
    //         curr = curr.next;
    //     }
    //     System.out.println();
    // }

    // MAIN with 8 elements
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head
                = arrayToLinkedList(new int[]{4, 2});
        head = sol.sortList(head);
        printLinkedList(head);
    }
}
