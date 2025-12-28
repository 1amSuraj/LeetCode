class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean [] t = new Boolean[n];
        return helper(s, wordDict, 0, n ,t);
    }
    public boolean helper(String s , List<String> dic, int idx, int n, Boolean[] t){
        if(idx==n) return true;
        if(t[idx]!= null) return t[idx];
        for(int endIdx = idx+1;endIdx <= n; endIdx++){
            String split = s.substring(idx, endIdx);
            if(dic.contains(split) && helper(s, dic , endIdx, n, t)){
                return t[idx]=true;
            }
        }
        return t[idx]=false;
    }
}