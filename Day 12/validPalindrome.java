class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) - 'a' < 0 || s.charAt(i) - 'a' > 25) {
                System.out.print("We found " + s.charAt(i) + " at i which is invalid!\n");
                i++;
                continue;
            }

            if (s.charAt(j) - 'a' < 0 || s.charAt(j) - 'a' > 25) {
                System.out.print("We found " + s.charAt(i) + " at j which is invalid!\n");
                j--;
                continue;
            }

            if (s.charAt(i++) != s.charAt(j--)) {
                System.out.print(s.charAt(i) + " is not equal to " + s.charAt(j));
                return false;
            }

        }

        return true;
    }
}
