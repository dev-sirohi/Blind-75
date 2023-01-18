/*
This is the optimised solution,
We cannot use the two pointer one because idk I was getting errors,
anyway two pointer uses O(nlogn) and hashmap one uses O(n) and average case is lower.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = i;
                arr[1] = map.get(target - nums[i]);
            }
            
            map.put(nums[i], i);
        }
        
        return arr;
    }
}
