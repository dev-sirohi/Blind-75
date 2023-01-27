class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        
        int i = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for (int j = 0; j < nums.length; j++) {
            if (!set.add(nums[j])) {
                return true;
            }
            
            if (set.size() > k) {
                set.remove(nums[i++]);
            }
        }
        
        return false;
    }
}
