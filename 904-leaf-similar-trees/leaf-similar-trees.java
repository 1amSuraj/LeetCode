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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        leafWord(root1,sb1); 
        leafWord(root2,sb2); 
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return sb1.toString().equals(sb2.toString());
    }
    public void leafWord(TreeNode root, StringBuilder sb){
        if(root == null) return;
        if(root.left== null && root.right == null) {
            sb.append(root.val+",");
        }
        leafWord(root.left,sb);
        leafWord(root.right,sb);
    }
}