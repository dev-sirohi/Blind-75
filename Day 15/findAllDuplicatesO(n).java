class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            }

            nums[index] *= -1;
        }

        return res;
    }
}

/*

What were doing is were taking the nums[abs(nums[i]) - 1] so that whenever we find it again the same position will already be negative and we'll know it is a duplicate.

*/
