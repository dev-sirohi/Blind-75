class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }

            if (nums[j - 1] > nums[j]) {
                return nums[j];
            }

            i++;
            j--;
        }

        return nums[0];
    }
}
