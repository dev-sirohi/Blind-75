class Solution {
    public int romanToInt(String s) {
        int sum = 0, num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            if (4 * num < sum) sum -= num;
            else sum += num;
        }

        return sum;
    }
}

/*

So, VI is 5 + 1 because 4 * 5 = 20 is not < 1 so we get 6
But, IV is 1 + 5 and since 4 * 1 is < 5 we get 4 instead of 6.

*/
