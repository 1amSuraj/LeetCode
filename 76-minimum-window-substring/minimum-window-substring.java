class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int left = 0;
        int start = 0;
        int req = t.length();
        int minLength = Integer.MAX_VALUE;
        for(int r = 0;r < s.length() ; r++){
            char ch = s.charAt(r);
            if(freq[ch]>0){
                req--;
            }
            freq[ch]--;
            while(req==0){
                if(r-left+1<minLength){
                    minLength = r - left +1;
                    start = left;
                }
                char l = s.charAt(left);
                freq[l]++;
                if(freq[l]>0){
                    req++;
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE? "": s.substring(start,start+minLength);
    }
}