class Solution {
    public int maxSum(int[] nums) {
        int s = 0;
        HashSet<Integer> set = new HashSet<>();
        boolean posi = false;
        for(int a:nums){
            if(a>0){
                posi=true;
                if(set.add(a)){
                    s+= a;
                }
            }
        }
        if (posi) return s;
        int max = Integer.MIN_VALUE;
        for(int a:nums){
            max = Math.max(max,a);
        }
        return max;
    }
}