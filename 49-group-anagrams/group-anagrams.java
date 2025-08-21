class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String> > map = new HashMap<>();
        for (String s : strs) {
            char arr[] = new char[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String k = String.valueOf(arr);
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        return new ArrayList<>(map.values());
    }
}