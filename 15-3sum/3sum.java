class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i+1;j<n;j++){
                int complement = target - nums[j];
                if(map.containsKey(complement)) {
                    List<Integer> Triplet = Arrays.asList(nums[i],nums[j],complement);
                    Collections.sort(Triplet);
                    set.add(Triplet);
                }
                map.put(nums[j],j);
            }
        }
        return new ArrayList<>(set);
    }
}