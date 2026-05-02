/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
*/
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNewMap = new TreeMap<>();
        
        Node headCurr = head;
        Node res = new Node(-1);
        Node resCurr = res;

        while(headCurr != null) {
            Node newCurr = new Node(headCurr.val);
            resCurr.next = newCurr;

            oldNewMap.put(headCurr, newCurr);

            resCurr = resCurr.next;
            headCurr = headCurr.next;
        }

        headCurr = head;
        resCurr = res.next;

        while(headCurr != null) {
            resCurr.random = oldNewMap.get(headCurr.random);

            resCurr = resCurr.next;
            headCurr = headCurr.next;
        }

        return res.next;
    }
}
// @lc code=end

