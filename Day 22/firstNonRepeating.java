public class Solution {
    public String solve(String A) {
        int[] arr = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        char[] res = new char[A.length()];
        
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            
            arr[c - 'a']++;
            if (arr[c - 'a'] == 1) q.add(c);
            while (!q.isEmpty() && arr[q.peek() - 'a'] > 1) q.poll();
            if (q.isEmpty()) res[i] = '#';
            else res[i] = q.peek();
        }
        
        return new String(res);
    }
}

/*

Use a queue bitch

*/
