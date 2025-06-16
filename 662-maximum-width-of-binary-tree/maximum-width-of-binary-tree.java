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
    class Pair{
        TreeNode node;
        int bt;
        Pair(TreeNode node, int bt){
            this.node = node;
            this.bt = bt;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
    
        int width = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            int left =0,right=0;
            for(int i =0;i<n;i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int bt = pair.bt;
                if(i==0) left = bt;
                if(i==n-1) right = bt;
                if(node.left!=null) queue.offer(new Pair(node.left,bt*2-1));
                if(node.right!=null) queue.offer(new Pair(node.right,bt*2 ));
            }
            width = Math.max(width, right+(-left)+1);
        }
        return width;
    }
}