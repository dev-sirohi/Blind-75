/*
All we're doing is, instead of checking for each pair if their sum is a multiple of 2,
we are taking the 2^20 limit in array values to only check for 21 values for each element.
Then we're storing each element and their occurence in the hashmap because, again, it works in pairs, and if one doesn't exist inside at one point, the other will later find it.
So we are only iterating through the array once but checking 21 times for each element so TC is O(21*n) which is still better than O(n^2) that we got from brute force.
Also, we are keeping occurence because there can be same elements at different positions that would form the pair with a single another element as well,
for example (1, 1, 2), the two 1s will for two separate pairs with 2 but since we can't keep similar elements in hashmap we keep the occurence and count 2 instead of 1 in res.
*/

class Solution {
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int M = 1000000007;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : deliciousness) {
            int sum = 1;
            for (int j = 0; j <= 21; j++) {
                if (sum >= num && map.containsKey(sum - num)) {
                    res += map.get(sum - num);
                    res %= M;
                }
                sum *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return res;
    }
}

/*
Brute Force O(n^2)

public int countPairs(int[] deliciousness) {
    int n = deliciousness.length;
    int M = 1000000007;
    int res = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (power(deliciousness[i] + deliciousness[j])) {
                res++;
                res = res % M;
            }
        }
    }

    return res;
}

Boolean power(int a) {
    while (a != 1) {
        if (a % 2 != 0) {
            return false;
        }
        a /= 2;
    }

    return true;
}

*/
