class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            max = Math.max((Math.min(height[left], height[right]) * (right - left)), max);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

/*
The logic here is that, we need more width and more height to have more area.
Now, if we have one longer height and one shorter height, and we're decreasing the width with each iteration, why would we decrease the width AND the height? We'll obviously keep the longer one in hopes that we'll find some higher length or equal. If we choose smaller, then we're limiting ourselves.
*/
    }
}

/*

Bruteforce

int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int sum = Math.min(height[j], height[i]) * (j - i);
                max = Math.max(max, sum);
            }
        }

        return max;

*/
