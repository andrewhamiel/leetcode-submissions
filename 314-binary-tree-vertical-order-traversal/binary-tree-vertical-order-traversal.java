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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int row = 0, minCol = 0, maxCol = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode curr = p.getKey();
                int col = p.getValue();
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                
                adj.computeIfAbsent(col, k -> new ArrayList<>()).add(new Pair<>(row, curr.val));

                if(curr.left != null) q.add(new Pair<>(curr.left, col - 1));
                if(curr.right != null) q.add(new Pair<>(curr.right, col + 1));
            }
            row++;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int col = minCol; col <= maxCol; col++) {
            if(adj.containsKey(col)){
                List<Pair<Integer, Integer>> pairs = adj.get(col);
                Collections.sort(pairs, (a, b) -> a.getKey() - b.getKey());
                List<Integer> list = new ArrayList<>();
                for(Pair<Integer, Integer> pair : pairs) list.add(pair.getValue());
                result.add(list);
            }          
        }
        return result;
    }
}