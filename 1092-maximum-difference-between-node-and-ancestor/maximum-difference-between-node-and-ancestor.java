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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root, int maxA, int minA){
        if(root==null) return maxA - minA;
        
        maxA = Math.max(maxA, root.val);
        minA = Math.min(minA, root.val);  
        int left = dfs(root.left,maxA,minA);
        int right = dfs(root.right,maxA,minA);
        return Math.max(left, right);
    }
}