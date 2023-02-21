
/*
This is my first approach.
I thought this would be good, nice, fast. I got 5% beat on both time complexity and space complexity. wtf.

class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String res = new String();

        int right = 0;

        while (s.charAt(right) == ' ') right++;
        int left = right;
        
        while (right < s.length()) {
            System.out.println("Checking: " + s.charAt(right));
            if (s.charAt(right) == ' ') {
                stack.add(s.substring(left, right));
                while (right < s.length() && s.charAt(right) == ' ') right++;
                left = right;
            } else if (right == s.length() - 1) {
                stack.add(s.substring(left, right + 1));
                break;
            } else right++;
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
            res += " ";
        }

        return res.substring(0, res.length() - 1);
    }
}

*/
