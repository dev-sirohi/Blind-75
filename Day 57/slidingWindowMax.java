class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Monotonically Decreasing Deque solution

        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int ri = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // remove left most element
            // only runs in case nothing smaller has been found yet and leftmost is out of the window
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // remove smaller elements
            // We need because the leftmost contains the largest num, so if there's something smaller after it and we are adding something smaller than leftmost and greater than the not leftmost, then we won't be able to remove the non leftmost so we start from the end because in the right nothing will ever be greater since this is a monotonically decreasing deque question.
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);

            // only starts adding to res when pointer reaches atleast k index
            if (i >= k - 1) {
                res[ri++] = nums[q.peek()];
            }
        }

        return res;
    }
}

/*

// Bruteforce: Successfull - O(n * (k + (k * log(k))))
        int[] res = new int[nums.length - k + 1];
        int l = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] arr = new int[k];
            for (int j = i; j < i + k; j++) {
                arr[j - i] = nums[j];
            }
            Arrays.sort(arr);
            res[l++] = (arr[k - 1]);
        }

        return res;

*/
