// Node class

class Node {

    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Stack class
class myStack {

    Node head = new Node(-1);
    Node curr = head;

    public myStack() {

    }

    public boolean isEmpty() {
        return (curr == head);
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        curr.next = new Node(x);
        curr = curr.next;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        // Removes the front element of the stack.
        Node temp = head;
        while (temp.next != curr) {
            temp = temp.next;
        }

        curr = temp;
        temp.next = null;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return curr.data;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        Node temp = head;
        int count = 0;

        while (temp != curr) {
            temp = temp.next;
            count++;
        }

        return count;
    }
}
