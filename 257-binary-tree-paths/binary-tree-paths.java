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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root ==null) return res;
        StringBuilder sb = new StringBuilder();
        dfs(root,res,sb);
        return res;
    }
    public void dfs(TreeNode root,List<String> res, StringBuilder sb){
        if(root.left==null && root.right==null) {
            sb.append(""+root.val);
            res.add(sb.toString());
            return;
        }
        if(root.left!=null){
            String prev = sb.toString();
            sb.append(root.val+"->");
            dfs(root.left,res,sb);
            sb = new StringBuilder(prev);
        }
        if(root.right!=null){
            sb.append(root.val+"->");
            dfs(root.right,res,sb);
        }


    }
}