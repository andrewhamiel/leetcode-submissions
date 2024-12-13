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
    Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        seen.add(target.val);

        while(!q.isEmpty() && k >= 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(k == 0) {
                    result.add(curr.val);
                    continue;
                }

                for(TreeNode neighbor : adj.getOrDefault(curr, new HashSet<>())) {
                    if(!seen.contains(neighbor.val)) {
                        seen.add(neighbor.val);
                        q.add(neighbor);
                    }
                }
            }
            k--;
        }

        return result;
    }

    private void buildGraph(TreeNode child, TreeNode parent) {
        if(parent != null) {
            adj.computeIfAbsent(child, k -> new HashSet<>()).add(parent);
            adj.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
        }
        if(child.left != null) buildGraph(child.left, child);
        if(child.right != null) buildGraph(child.right, child);
    }
}