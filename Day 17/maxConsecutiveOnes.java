class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE, currCount = 1;

        int left = 0;

        while (left < nums.length) {
            int right = left;
            while (right < nums.length && nums[right] == 1) right++;
            currCount = right - left;
            maxCount = Math.max(maxCount, currCount);
            left = right + 1;
        }

        return Math.max(currCount, maxCount);
    }
}
