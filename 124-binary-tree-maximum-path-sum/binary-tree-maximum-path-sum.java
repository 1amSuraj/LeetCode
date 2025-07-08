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
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0]=Integer.MIN_VALUE;
        f(root, max);
        
        return max[0];
        
    }
    public int f(TreeNode root, int[] max) {
        if (root == null) return 0;
        
        int left = Math.max(0, f(root.left, max)); //cuz if we take -1 then [2,-1 ] will fail
        int right = Math.max(0, f(root.right, max));
        
        max[0] = Math.max(max[0], left + right + root.val); 
        
        return root.val + Math.max(left, right);
    }
}