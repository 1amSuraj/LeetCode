class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0 ;
        int maxf = 0;
        int maxA = 0;
        int[] freq = new int[26];

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            freq[ ch - 'A' ]++;
            maxf = Math.max(maxf,freq[ch - 'A']);

            while( right-left+1 - maxf > k ){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxA = Math.max(maxA,right-left+1);
        }
        return maxA;
    }
}