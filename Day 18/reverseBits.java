public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;

        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>= 1;
        }

        return res;
    }
}

/*

So basically what we're doing is we left shift the res take the n and take its last bit if its 1 then we add it to the res and then right shift the n
by the time we are done the last 1 of n will be the first 1 of res because as we right shift n we left shift res

*/
