// Helper class to store the node and its coordinates (row, column)
class Tuple {
    TreeNode node;
    int row;     // vertical depth
    int column;  // horizontal position

    public Tuple(TreeNode node, int row, int column) {
        this.node = node;
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // columnMap[column][row] = list of values (min-heap to sort when tied)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap = new TreeMap<>();

        // Queue for BFS traversal: stores node with row and column
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // root is at row = 0, column = 0

        // Start BFS traversal
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int column = tuple.column;

            // Create nested map if column is not present
            if (!columnMap.containsKey(column)) {
                columnMap.put(column, new TreeMap<>());
            }

            // Create priority queue for this row if not present
            if (!columnMap.get(column).containsKey(row)) {
                columnMap.get(column).put(row, new PriorityQueue<>());
            }

            // Add current node's value to the right column and row
            columnMap.get(column).get(row).offer(node.val);

            // Add left and right children to the queue with updated row & column
            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, column + 1));
            }
        }

        // Now build the final answer list
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rowMap : columnMap.values()) {
            List<Integer> vertical = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rowMap.values()) {
                while (!pq.isEmpty()) {
                    vertical.add(pq.poll());
                }
            }

            result.add(vertical);
        }

        return result;
    }
}

