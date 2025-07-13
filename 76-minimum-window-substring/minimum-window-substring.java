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
                    if ((r - l + 1) < min) {
                    min = r - l + 1;
                    maxL = l;
                    maxR = r;
                    }
                    if(map1.containsKey(s.charAt(l))){
                        map1.put(s.charAt(l), map1.get(s.charAt(l))-1);
                    }
                    l++;
                }
            }
            // if(maxL==0 && maxR==0) return "";
        return min == Integer.MAX_VALUE ? "" : s.substring(maxL, maxR + 1);
        
    }
    public static boolean hasSufficientFrequency(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            char ch = entry.getKey();
            int freqInMap2 = entry.getValue();
            int freqInMap1 = map1.getOrDefault(ch, 0);
            
            if (freqInMap1 < freqInMap2) {
                return false;
            }
        }
        return true;
    }

}