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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(root==null) return res;
    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         List<Integer> curList = new ArrayList<>();
    //         for(int i=0;i<size;i++) {
    //             TreeNode rem = q.remove();
    //             if (rem.left != null) {
    //                 q.add(rem.left);
    //             }
    //             if (rem.right != null) {
    //                 q.add(rem.right);
    //             }
    //             curList.add(rem.val);
    //         }
    //         res.add(curList);
    //     }

    //     return res;
    // }
//     public List<List<Integer>> levelOrder(TreeNode root){
//         Queue<TreeNode> queue = new LinkedList<>();
//         List<List<Integer>> ans = new ArrayList<>();
//         if(root == null) return ans;
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             List<Integer> arr = new ArrayList<>();
//             for(int i = 0 ; i<size;i++){
//                 if(queue.peek().left!=null) queue.offer(queue.peek().left);
//                 if(queue.peek().right!=null) queue.offer(queue.peek().right);
//                 arr.add(queue.poll().val);
//             }
//             ans.add(arr);
//         }
//         return ans;
//     }
// }

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll(); // get current node
            level.add(node.val);          // add its value

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        ans.add(level); // add the current level's list to result
    }

    return ans;
}
}