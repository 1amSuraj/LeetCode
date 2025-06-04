/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        ArrayList<ArrayList<Integer>> a = f(root.left);
        ArrayList<ArrayList<Integer>> b = f(root.right);
        for (ArrayList<Integer> inner : b) {
            Collections.reverse(inner);
        }
        if (a.equals(b))
            return true;
        return false;
    }

    public static ArrayList<ArrayList<Integer>> f(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                TreeNode node = queue.poll();
                if (node == null) {
                    arr.add(null);
                    continue;
                }
                arr.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res.add(arr);
        }
        return res;
    }
}