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
// public class BSTIterator{
//     private Stack<TreeNode> stack = new Stack<>();
//     boolean reverse = true;
//     public BSTIterator(TreeNode root,Boolean isReverse){
//         reverse = isReverse;
//         pushAll(root);
//     }
//     public boolean hasNext() {
//         return !stack.isEmpty();
//     }
//     public int next(){
//         TreeNode temp = stack.pop();
//         if(reverse) pushAll(temp.right);
//         else pushAll(temp.left);
//         return temp.val;
//     }
//     private void pushAll(TreeNode root){
//         while(root!=null){
//             stack.push(root);
//             if(reverse) root = root.right;
//             else root = root.left;
//         }
//     }
// }
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         if(root==null) return false;
//         BSTIterator l = new BSTIterator(root,false);
//         BSTIterator r = new BSTIterator(root,true);
//         int i = l.next();
//         int j = r.next();
//         while( i<j){
//             if(i+j==k) return true;
//             else if(i+j<k) {
//                 if (l.hasNext()) i = l.next();
//             else break;

//             }
            
//             else {
//                 if (r.hasNext()) j = r.next();
//             else break;
//             }
//         }
//         return false;
//     }
// }
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        this.reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (!reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator l = new BSTIterator(root, false); // Inorder
        BSTIterator r = new BSTIterator(root, true);  // Reverse Inorder

        int i = l.next();
        int j = r.next();

        while (i < j) {
            int sum = i + j;
            if (sum == k) return true;
            else if (sum < k) {
                if (l.hasNext()) i = l.next();
                else break;
            } else {
                if (r.hasNext()) j = r.next();
                else break;
            }
        }

        return false;
    }
}
