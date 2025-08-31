class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,result,new ArrayList<>());
        return result;
    }
    static void backtrack(int idx,int[] nums,List<List<Integer>> result,List<Integer> temp)
    {
        if(idx==nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backtrack(idx+1,nums,result,temp);
        temp.remove(temp.size()-1);
        while(idx+1 < nums.length && nums[idx]==nums[idx+1]) idx++;
        backtrack(idx+1,nums,result,temp);
    }
}