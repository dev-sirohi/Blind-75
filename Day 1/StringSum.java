/*
I am completely satisfied with this solution. For now.
*/

class Solution {
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]).equals(target)) {
                    res++;
                }
                
                if ((nums[j] + nums[i]).equals(target)) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
