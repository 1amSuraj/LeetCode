class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> seen = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = s.length();
        String sb = "";
        for(char ch : s.toCharArray()){
            sb+=ch;
            if(seen.add(sb)){
                res.add(sb);
                sb="";
            }
        }
        return res;
    }
}