class Solution {
    public String longestPalindrome(String s) {
        int maxCount = 0;
        String maxString = "";

        for (int i = 0; i < s.length(); i++) {
            // odd case
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxCount) {
                    maxString = s.substring(left, right + 1);
                    maxCount = right - left + 1;
                }

                left--;
                right++;
            }   

            // even case
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxCount) {
                    maxString = s.substring(left, right + 1);
                    maxCount = right - left + 1;
                }

                left--;
                right++;
            }
        }

        return maxString;
    }
}
