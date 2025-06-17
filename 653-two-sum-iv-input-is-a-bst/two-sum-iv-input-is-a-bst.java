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
public class BSTIterator{
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root,Boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public int next(){
        TreeNode temp = stack.pop();
        if(reverse) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }
    private void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse) root = root.right;
            else root = root.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();//before()
        while( i<j){
            if(i+j==k) return true;
            else if(i+j<k) {
                i = l.next();
            }
            else {
                j = r.next();
            }
        }
        return false;
    }
}