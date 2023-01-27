class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;

    }
}

/*

Using hashset, not fast enough

HashSet<Integer> set = new HashSet<>();
        
for (int i = 0; i < nums.length; i++) {
    if (set.contains(nums[i])) {
        return true;
    }

    set.add(nums[i]);
}

return false;

Using sorting, again not fast enough

Arrays.sort(nums);

for (int i = 1; i < nums.length; i++) {
    if (nums[i] == nums[i - 1]) {
        return true;
    }
}

return false;

Using hashset, stupid me

HashSet<Integer> set = new HashSet<>();
        
for (int i = 0; i < nums.length; i++) {
    if (!set.add(nums[i])) {
        return true;
    }
}

return false;
*/
