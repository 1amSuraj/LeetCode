/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root,p,q);
    }
    public TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;

        TreeNode a = f(root.left, p , q);
        TreeNode b = f(root.right, p , q);
        if(a!=null && b!=null) return root;
        if(a==null) return b;
        return a;
    }
}