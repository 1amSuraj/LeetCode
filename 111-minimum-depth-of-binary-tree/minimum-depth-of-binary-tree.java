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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return dfs(root,1);
    }
    //can be done easily with BFS
    public int dfs(TreeNode root, int depth){
        if(root==null) return Integer.MAX_VALUE;
        if(isLeaf(root)) return depth;
        int left = dfs(root.left, depth+1);
        int right = dfs(root.right ,depth+1);
        return Math.min(left, right);
    }
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right == null) return true;
        return false;
    }

}