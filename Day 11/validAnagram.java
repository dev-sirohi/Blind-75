class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[26];

        for (char c : s.toCharArray()) {
            arr1[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            arr1[c - 'a']--;
        }

        for (int i : arr1) {
            if (i != 0) return false;
        }

        return true;
    }
}

/*

We don't need two arrays and compare them. We can just use one array by increasing values first then decreaming them and if anything other than 0 is left then we know it's not a palindrome.

My way:

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'A']++;
            arr2[t.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 128; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}

*/
