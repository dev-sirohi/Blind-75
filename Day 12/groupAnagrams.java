class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            if (!map.containsKey(new String(chArr))) {
                map.put(new String(chArr), new ArrayList<>());
            }
            map.get(new String(chArr)).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

/*

So what we're doing is, we're taking each string, sorting it, then adding it into the hashmap.
If the hashmap contains that already, then we simply add the real, unsorted string into the arraylist associated with the sorted string.
If it doesn't, then we add the sorted key into the hashmap and create a new arraylist as its value.
Then we add the unsorted string itself into the list.

*/
