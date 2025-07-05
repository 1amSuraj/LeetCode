class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        func(0,target,candidates,res,new ArrayList<>());
        return res;
    }
    public void func(int i , int target, int[] candidates, List<List<Integer>> res,List<Integer> arr){
        if(i==candidates.length ) {
            if(target==0) res.add(new ArrayList<>(arr));
            return;
        }
        if(candidates[i]<=target){
            arr.add(candidates[i]);
            func(i,target-candidates[i],candidates,res,arr);
            arr.remove(arr.size()-1);
        }
        func(i+1, target,candidates, res,arr);
    }
}