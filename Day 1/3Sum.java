class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();   
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;

                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];

                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        low++;
                        high--;
                    } else {
                        if (sum < 0) {
                            low++;
                            // while (low < high && nums[low] == nums[low + 1]) low++;
                        } else {
                            high--;
                            // while (low < high && nums[high] == nums[high - 1]) high--;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}

/*

This is what I came up with, with mistakes!

HashSet<List<Integer>> res = new HashSet<>();   
Arrays.sort(nums);

for (int i = 0; i < nums.length - 2; i++) {
    if (i == 0 || nums[i] != nums[i - 1]) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];

            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;
            } else {
                if (sum < 0) {
                    low++;
                    while (low < high && nums[low] == nums[low - 1]) low++;
                } else {
                    high--;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                }
            }
        }
    }
}

return new ArrayList<>(res);


This is Striver's solution!

Arrays.sort(num);

ArrayList < ArrayList < Integer >> res = new ArrayList < > ();

for (int i = 0; i < num.length - 2; i++) {

    if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

        int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

        while (lo < hi) {
            if (num[lo] + num[hi] == sum) {
                ArrayList < Integer > temp = new ArrayList < > ();
                temp.add(num[i]);
                temp.add(num[lo]);
                temp.add(num[hi]);
                res.add(temp);

                while (lo < hi && num[lo] == num[lo + 1]) lo++;
                while (lo < hi && num[hi] == num[hi - 1]) hi--;

                lo++;
                hi--;
            } else if (num[lo] + num[hi] < sum) lo++;

            else hi--;
        }
    }
}
return res;

*/
