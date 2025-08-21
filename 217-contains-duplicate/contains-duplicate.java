class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums){
            if(!set.add(a)){
                return true;
            }
        }
        return false;
    }
}