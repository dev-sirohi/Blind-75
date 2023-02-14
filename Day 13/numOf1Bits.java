public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }

        return count;
    }
}

/*

So, what were doing is
were &ing with 1 because 1 in 32 bits is 000...0001
and only 1 & 1 is 1 otherwise its all 0
so we're adding 1 if the last digit if binstr is 1
then were shifting it to the right
now, in cpp we could have used >> but java doesn't have unsigned binstrs
so that means it goes around in a loop.
the max_int + 1 value is min_int in java.
so we have to take care of this.

(side note:
what >>> does is,
in 32 bits signed integer.
the first bit is reserved for the sign -/+
but for unsigned its simply filled with 0

AND THAT IS WHY THE n % 2 didn't work. It was giving one less 1 because in a 
signed integer that would be a - reserve bit
but in unsigned its just another 0
so when counting
- would count as a 1
but in unsigned its counted as 0
hence 30 instead of 31
that one in 31 is - reserved bit
)

Slow approach
Actually stupid approach because were not getting a number n were directly getting the binstre so im literally just wasting time

String binstr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binstr.length(); i++) {
            if (binstr.charAt(i) == '1') count++;
        }

        return count;

*/
