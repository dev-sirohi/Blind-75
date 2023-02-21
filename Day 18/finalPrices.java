class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(prices[prices.length - 1]);
        res[prices.length - 1] = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = prices[i];
            } else {
                res[i] = prices[i] - stack.peek();
            }
            
            stack.push(prices[i]);
        }

        return res;
    }
}
