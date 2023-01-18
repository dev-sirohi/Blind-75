/*
This is different from the TwoSum because
We have to keep multiple same elements before we can finally remove them.
In two sum we were removing elements as soon as we got the target,
but here we might have to add the same element until we get the next pair.
There are more than one solutions so it matters that there are two 1s or only one.
Both 1s could be used in pair with 3s and if we don't add the same elements we will lose one of the solutions!
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0) {
                res++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        return res;
    }
}
