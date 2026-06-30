/*
 * @lc app=leetcode id=2296 lang=java
 *
 * [2296] Design a Text Editor
 */

// @lc code=start
class Node {
    char val;
    Node next, prev;

    Node() {
    }

    Node(char val) {
        this.val = val;
    }
}

class TextEditor {

    Node head;
    Node cursor;

    public TextEditor() {
        head = new Node();
        cursor = head;
    }

    public void addText(String text) {
        Node end = cursor.next;
        for (char c : text.toCharArray()) {
            cursor.next = new Node(c);
            cursor.next.prev = cursor;
            cursor = cursor.next;
        }

        cursor.next = end;
        if (end != null)
            end.prev = cursor;
    }

    public int deleteText(int k) {
        int count = 0;
        Node end = cursor.next;
        while (cursor != head && k-- != 0) {
            count++;
            cursor = cursor.prev;
        }
        cursor.next = end;
        if(end != null) end.prev = cursor;

        return count;
    }

    public String cursorLeft(int k) {
        while (cursor != head && k-- != 0) {
            cursor = cursor.prev;
        }

        StringBuilder sb = new StringBuilder();
        Node temp = cursor;
        for(int i = 0; i < 10; i++) {
            if(temp == head) break;

            sb.insert(0, temp.val);
            temp = temp.prev;
        }

        return sb.toString();
    }

    public String cursorRight(int k) {
        while (cursor.next != null && k-- != 0) {
            cursor = cursor.next;
        }

        StringBuilder sb = new StringBuilder();
        Node temp = cursor;
        for(int i = 0; i < 10; i++) {
            if(temp == head) break;

            sb.insert(0, temp.val);
            temp = temp.prev;
        }

        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
// @lc code=end
