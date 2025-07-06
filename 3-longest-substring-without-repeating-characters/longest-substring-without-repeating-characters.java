class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int l =0;
        int r = 0;
        int n = s.length();
        int max = 0 ;
        for(int i = 0 ;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                l = Math.max(l, map.get(ch) + 1);  // Don't move l backward
                map.remove(ch);
            }
            map.put(ch,i);
            max = Math.max(max, i-l+1);
        }
        return max;
    }
}