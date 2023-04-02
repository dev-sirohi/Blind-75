class MinStack {

    private class Node {
        int val, min;
        Node next;
    }

    private Node head;

    public MinStack() {
        head = new Node();
        head.next = null;
    }
    
    public void push(int val) {
        int min;
        if (head.next == null) min = val;
        else min = head.next.min;

        Node node = new Node();
        node.val = val;
        if (val < min) {
            node.min = val;
        } else {
            node.min = min;
        }

        node.next = head.next;
        head.next = node;
    }
    
    public void pop() {
        head.next = head.next.next;
    }
    
    public int top() {
        return head.next.val;
    }
    
    public int getMin() {
        return head.next.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
