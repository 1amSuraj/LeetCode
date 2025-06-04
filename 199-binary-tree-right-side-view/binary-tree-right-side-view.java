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
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         ArrayList<Integer> arr= new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int n= queue.size();
//             for(int i = 0;i<n-1;i++){
//                 if(queue.peek().left!=null ) queue.offer(queue.peek().left);
//                 if(queue.peek().right!=null ) queue.offer(queue.peek().right);
//                 queue.poll();
//             }
//             TreeNode q = queue.poll();
//             if(q!=null){
//             if(q.left!=null) queue.offer(q.left);
//             if(q.right!=null) queue.offer(q.right);
//             arr.add(q.val);
//             }
//         }
//         return arr;
//     }
// }


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result; // null check

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                // Add the last node in the current level
                if (i == n - 1) {
                    result.add(node.val);
                }

                // Queue up children for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}