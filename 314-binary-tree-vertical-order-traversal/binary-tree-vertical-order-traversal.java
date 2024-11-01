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
    Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    int minCol = 0, maxCol = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {    
        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++) {
            if(map.containsKey(i)){
            List<Pair<Integer, Integer>> list = map.get(i);
            Collections.sort(list, (a, b) -> a.getKey() - b.getKey());
            List<Integer> toAdd = new ArrayList<>();
            for(Pair<Integer, Integer> p : list) toAdd.add(p.getValue());
            result.add(toAdd);
            }
            
        }
        return result;
    }

    private void dfs(TreeNode root, int row, int col) {
        if(root == null) return;
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair<>(row, root.val));

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}