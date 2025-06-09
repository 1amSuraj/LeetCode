/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode , TreeNode > parentmap = new HashMap<>();
        parentree(root, parentmap);
        HashMap<TreeNode , Boolean > visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int dis = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            if(dis == k ) break;
            dis++;
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    visited.put(node.left,true);
                    queue.offer(node.left);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    visited.put(node.right,true);
                    queue.offer(node.right);
                }
                if(parentmap.get(node)!=null && visited.get(parentmap.get(node))==null){
                    visited.put(parentmap.get(node),true);
                    queue.offer(parentmap.get(node));
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!queue.isEmpty()){
            arr.add(queue.poll().val);
        }
        return arr;
    }
    public void parentree(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    map.put(node.left,node);
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    map.put(node.right,node);
                    queue.offer(node.right);
                }
            }
        }
    }
}