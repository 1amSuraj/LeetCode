class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch: t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch,0)+1);
        }
        int l = 0;
        int min = Integer.MAX_VALUE;
        int maxL = 0;
        int maxR = 0;
        for(int r = 0;r<n;r++){
            char ch = s.charAt(r);
            if(map2.containsKey(ch)){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }
                while(hasSufficientFrequency(map1,map2)){
                    if ((r-l+1)< min) {
                    min= r - l+ 1;
                    maxL= l;
                    maxR= r;
                    }
                    if(map1.containsKey(s.charAt(l))){
                        map1.put(s.charAt(l), map1.get(s.charAt(l))-1);
                    }
                    l++;
                }
            }
        return min == Integer.MAX_VALUE? "" : s.substring(maxL, maxR + 1);
        
    }
    public static boolean hasSufficientFrequency(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    for (char ch : map2.keySet()) {
        if (map1.getOrDefault(ch, 0) < map2.get(ch)) {
            return false;
        }
    }
    return true;
}

}