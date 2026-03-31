class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

class Solution {
    public Node segregate(Node head) {
        Node head0 = new Node(-1), head1 = new Node(-1), head2 = new Node(-1);
        Node curr0 = head0, curr1 = head1, curr2 = head2;
        while(head != null){
            switch (head.data) {
                case 0:
                    curr0.next = head;
                    curr0 = curr0.next;
                    break;
                case 1:
                    curr1.next = head;
                    curr1 = curr1.next;
                    break;
                case 2:
                    curr2.next = head;
                    curr2 = curr2.next;
                    break;
            }
            head = head.next;
        }
        curr0.next = head1.next;
        curr1.next = head2.next;
        curr2.next = null;
        return head0.next;
    }
}