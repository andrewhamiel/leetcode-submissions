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
    private Map<Integer, List<Pair<TreeNode, Integer>>> map = new HashMap<>();
    int minCol = 0, maxCol = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++) {
            if(map.containsKey(i)) {
                List<Pair<TreeNode, Integer>> val = map.get(i);
                Collections.sort(val, (a, b) -> a.getValue() - b.getValue());
                List<Integer> list = new ArrayList<>();
                for(Pair<TreeNode, Integer> p : val) list.add(p.getKey().val);
                result.add(list);
            }
        }
        return result;
    }

    private void dfs(TreeNode root, int row, int col) {
        if(root == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair<>(root, row));
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}