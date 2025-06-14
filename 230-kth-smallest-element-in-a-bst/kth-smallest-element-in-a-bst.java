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

    public int kthSmallest(TreeNode root, int k) {
        int res[] = new int[1];
        int c[] = new int[1];
        res[0] = Integer.MAX_VALUE;
        c[0]=0;
        inorder(root,k,res,c);
        return res[0];
    }
    public void inorder(TreeNode root, int k , int[] res, int[] c){
        if(root==null || c[0]>k) return;
        inorder(root.left,k,res,c);
        c[0]++;
        if(c[0]==k){
            res[0] = root.val;
            return;
        }
        inorder(root.right,k, res, c);

    }
}