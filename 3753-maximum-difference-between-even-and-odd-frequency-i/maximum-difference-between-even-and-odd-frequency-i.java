class Solution {
    public int maxDifference(String s) {
        char[] arr = s.toCharArray();
        int character[] = new int[26];
        for(char ch : arr){
            character[ch-'a']++;
        }
        int omax = Integer.MIN_VALUE;
        int emin = Integer.MAX_VALUE;
        for(int c:character){
            if(c%2!=0 && c>omax) omax = c;
            if(c%2==0 &&c!=0&& c<emin) emin = c;
        }
        return omax-emin;
    }
}