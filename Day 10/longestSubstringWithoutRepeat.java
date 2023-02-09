class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int end = 0, start = 0;

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(start++));
            }
        }

        return max;
    }
}
