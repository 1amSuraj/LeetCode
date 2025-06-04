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
//     public boolean isSymmetric(TreeNode root) {
//         return isMirror(root.left, root.right);
//     }

//     public boolean isMirror(TreeNode t1, TreeNode t2) {
//         if (t1 == null && t2 == null) return true;
//         if (t1 == null || t2 == null) return false;
//         return (t1.val == t2.val)
//             && isMirror(t1.left, t2.right)
//             && isMirror(t1.right, t2.left);
//     }
// }





class Solution {
    public boolean isSymmetric(TreeNode root) {
        ArrayList<ArrayList<Integer>> a = f(root.left);
        ArrayList<ArrayList<Integer>> b = f(root.right);
        for (ArrayList<Integer> inner : b) {
            Collections.reverse(inner);
        }
        if (a.equals(b))
            return true;
        return false;
    }

    public static ArrayList<ArrayList<Integer>> f(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                TreeNode node = queue.poll();
                if (node == null) {
                    arr.add(null);
                    continue;
                }
                arr.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res.add(arr);
        }
        return res;
    }
}


