public class Solution {
    public int[] prevSmaller(int[] A) {
        int[] G = new int[A.length];
        G[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            
            G[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(A[i]);
        }
        
        return G;
    }
}
