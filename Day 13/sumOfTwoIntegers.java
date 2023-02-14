class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }

        return a;
    }
}

/*

So what we're doing is, were taking first the xor of a and b to add them but xor
doesn't deal with carry so we need to add and left shift them once to take care of the carry
and the and works as long as carry isnt 0 which means we cant add them anymore which means a & b provides nothing but 0

*/
