class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int[] charArray = new int[26];

        for (int end = 0; end < s.length(); end++) {
            charArray[s.charAt(end) - 'A'] = 1 + charArray[s.charAt(end) - 'A'];

            int maxChar = findMaxChar(charArray);

            if ((end - start + 1) - maxChar <= k) {
                max = Math.max(max, end - start + 1);
            } else {
                charArray[s.charAt(start++) - 'A']--;
            }
        }

        return max;
    }

    int findMaxChar(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}

/*

So whats happening here is that we have a window from start to end
and were saving the counts of each char in that window in a charArray
now, each time we add a charCount we check if the number of characters requiring change is greater or lesser than k
we check that by finding the max count of char in charArray then subtracting that from the window size because obviously the window will always be atleast equal or greater
and if the difference is more than k that means its something like ABAB where k = 1
so we'll rmeove one count from A by moving the slow pointer forward that will be like we actually shortened the window because now we have one less A but there is still one A left so we won't make it 0 directly.
and each time we take max(max, window_size) then return max

*/
