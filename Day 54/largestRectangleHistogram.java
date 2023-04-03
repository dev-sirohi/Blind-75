class Solution {
    public int largestRectangleArea(int[] heights) {
        // Optimized - Using Stack

        Stack<int[]> stack = new Stack<>();
        int max = 0;
        
        int j = 0;

        while (j < heights.length) {
            int index = j;
            if (stack.isEmpty()) {
                stack.push(new int[] {index, heights[j]});
            } else {
                while (!stack.isEmpty() && stack.peek()[1] > heights[j]) {
                    index = stack.peek()[0];
                    max = Math.max((j - stack.peek()[0]) * stack.peek()[1], max);
                    stack.pop();
                }

                stack.push(new int[] {index, heights[j]});
            }

            j++;
        }

        j = heights.length;

        while (!stack.isEmpty()) {
            max = Math.max((j - stack.peek()[0]) * stack.peek()[1], max);
            stack.pop();
        }

        return max;
    }
}

/*

Basically keep looking for heights smaller than the prev ones because that means the prev heights can't continue further.
In that case pop them after finding their contributed height using (curr index - their index) * height because thats how much they will contribute.
Also, before popping, their index will be stored for the curr height because since the curr height is smaller than them it can also reach backwards upto the point it is smaller.

Then whatever is left, we calculate their contributions and if theyre greater than max we store them.
Then return max.

*/

/*

// Bruteforce | Works | TLE
        
int max = Integer.MIN_VALUE;
int curr = Integer.MIN_VALUE;
int minElem;

for (int i = 0; i < heights.length; i++) {
    minElem = heights[i];
    for (int j = i; j < heights.length; j++) {
        if (i == j) {
            curr = heights[i];
        } else {
            if (heights[j] < minElem) minElem = heights[j];
            curr = minElem * (j - i + 1);
        }

        max = Math.max(curr, max);
    }
}

return max;

*/
