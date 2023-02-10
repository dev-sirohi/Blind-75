class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) return "";

        int start = 0, end = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), 1 + tmap.getOrDefault(t.charAt(i), 0));
        }

        long have = 0, need = tmap.size();
        int[] resRange = new int[2];
        int res = -1;

        while (end < s.length()) {
            char c = s.charAt(end);
            window.put(c, 1 + window.getOrDefault(c, 0));

            if (tmap.containsKey(c) && window.get(c).intValue() == tmap.get(c).intValue()) {
                have++;
            }

            while (start <= end && have == need) {
                if (res == -1 || end - start + 1 < res) {
                    resRange[0] = start;
                    resRange[1] = end;
                    res = end - start + 1;
                }
                char ch = s.charAt(start);
                window.put(ch, window.get(ch) - 1);
                if (tmap.containsKey(ch) && window.get(ch).intValue() < tmap.get(ch).intValue()) {
                    have--;
                }
                start++;
            }
            end++;
        }

        return res == -1 ? "" : s.substring(resRange[0], resRange[1] + 1);
    }
}

/*

Okay, so this is a tough question. Basically what we're doing is were starting a window and two hashmaps.
One hashmap is for s string values and the other one for t string values.
two variables have and need are used.
have is the characters we have in tmap also in map
need is chars in tmap

now, whenever have == need,
we save the window length because it means that that window is valid but possibly not the shortest
so as long as have == need, we shorten the window
the moment we lose one of the core chars, we start moving forward the window again
this process continues till end < s length
by then, we will surely have the shortest window possible
the complexity is O(n + m) because were checking one character by character and not looping inside loop


I don't know why we need the intValue() to pass the last testcase
*/
