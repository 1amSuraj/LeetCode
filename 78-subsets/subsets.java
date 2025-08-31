// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         backtrack(nums, 0, new ArrayList<>(), result);
//         return result;
//     }
    
//     private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
//         result.add(new ArrayList<>(path));
//         for (int i = start; i < nums.length; i++) {
//             path.add(nums[i]);
//             backtrack(nums, i + 1, path, result);
//             path.remove(path.size() - 1);
//         }
//     }
// }

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }
}