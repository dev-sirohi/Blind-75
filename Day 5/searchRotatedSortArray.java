class Solution {
    public int search(int[] nums, int target) {
        if (target <= nums[nums.length - 1]) {
            int i = nums.length - 1;

            while (i >= 0) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] < target) break;
                i--;
            }
        } else if (target >= nums[0]) {
            int i = 0;

            while (i < nums.length) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] > target) break;
                i++;
            }
        }

        return -1;
    }
}
