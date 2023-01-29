class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], res = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            res = Math.max(max, res);
        }

        return res;
    }
}

/*

// bruteforce

int max = 1;

for (int i = 0; i < nums.length; i++) {
    int sum = nums[i];
    for (int j = i + 1; j < nums.length; j++) {
        sum *= nums[j];
        max = Math.max(sum, max);
    }
}

return max;

*/
