class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;

        if (target <= nums[left]) return left;
        if (target > nums[right]) return right + 1;
        if (target == nums[right]) return right;
        
        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (target <= nums[mid]) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
