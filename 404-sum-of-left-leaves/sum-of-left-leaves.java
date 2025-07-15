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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    queue.offer(node.left);
                    if(isLeaf(node.left)) sum+=node.left.val;
                }
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return sum;
    }
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
}