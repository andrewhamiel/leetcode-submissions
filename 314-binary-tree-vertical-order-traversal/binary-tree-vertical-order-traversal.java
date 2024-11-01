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
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();
        q.add(new Pair<>(root, new int[]{0, 0}));

        int minCol = 0, maxCol = 0;
        while(!q.isEmpty()) {
            Pair<TreeNode, int[]> p = q.poll();
            TreeNode curr = p.getKey();
            int[] cell = p.getValue();
            int row = cell[0], col = cell[1];
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new Pair<>(row, curr.val));
            if(curr.left != null) q.add(new Pair<>(curr.left, new int[]{row + 1, col - 1}));
            if(curr.right != null) q.add(new Pair<>(curr.right, new int[]{row + 1, col + 1}));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++) {
            if(map.containsKey(i)){
                List<Pair<Integer, Integer>> pairList = map.get(i);
                Collections.sort(pairList, (a, b) -> a.getKey() - b.getKey());
                List<Integer> list = new ArrayList<>();
                for(Pair<Integer, Integer> p : pairList) list.add(p.getValue());
                result.add(list);
            }
        }
        return result;
    }
}