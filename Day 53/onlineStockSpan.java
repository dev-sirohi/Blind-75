// My solution: passes 99.35% solutions

class StockSpanner {
    class Node {
        int price, span;
        Node next;
    }

    Node head;

    StockSpanner() {
        head = new Node();
    }

    int next(int price) {
        if (head.next == null) {
            Node node = new Node();
            node.price = price;
            node.span = 1;
            node.next = null;
            head.next = node;
            return 1;
        }

        Node node = new Node();
        node.price = price;
        node.span = 1;
        
        while (head.next != null && head.next.price <= price) {
            node.span += head.next.span;
            head.next = head.next.next;
        }

        node.next = head.next;
        head.next = node;

        return node.span;
    }
}
 
 
 // My Other solution: passes only 24%
 
 class StockSpanner {
    Stack<int[]> stack = new Stack<>();

    int next(int price) {
        int[] spanner = new int[2];
        if (stack.isEmpty()) {
            spanner[0] = price;
            spanner[1] = 1;
            stack.push(spanner);
            return 1;
        }

        spanner[0] = price;
        spanner[1] = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            spanner[1] += stack.peek()[1];
            stack.pop();
        }

        stack.push(spanner);

        return spanner[1];
    }
}
