class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> result=new HashSet<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),result);
        return new ArrayList<>(result);
    }
    static void backtrack(int ind,int[] arr,int target,List<Integer> temp,HashSet<List<Integer>> result)
    {

        if(ind==arr.length)
        {
            if(target==0)
            result.add(new ArrayList<>(temp));
            return;
        }

        if(arr[ind]<=target)
        {
            temp.add(arr[ind]);
            backtrack(ind+1,arr,target-arr[ind],temp,result);
            temp.remove(temp.size()-1);
            while(ind+1 < arr.length && arr[ind]==arr[ind+1]) ind++;

        }
        backtrack(ind+1,arr,target,temp,result);

    }
}