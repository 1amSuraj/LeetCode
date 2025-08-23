// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> map= new HashMap<>();
//         int l =0;
//         int n = s.length();
//         int max = 0 ;
//         for(int i = 0 ;i<n;i++){
//             char ch = s.charAt(i);
//             if(map.containsKey(ch)){
//                 l = Math.max(l, map.get(ch) + 1);  // Don't move l backward
//                 map.remove(ch);
//             }
//             map.put(ch,i);
//             max = Math.max(max, i-l+1);
//         }
//         return max;
//     }
// }


//HashSet method

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>seen=new HashSet<>();
        int left=0;
        int maxlength=0;
        for(int right=0;right<s.length();right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}