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
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();
        buildGraph(root, null, adj);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);

        List<Integer> result = new ArrayList<>();

        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(dist == k) result.add(curr.val);

                for(TreeNode neighbor : adj.getOrDefault(curr, new HashSet<>())) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            dist++;
        }
        return result;
    }

    private void buildGraph(TreeNode root, TreeNode parent, Map<TreeNode, Set<TreeNode>> adj) {
        if(root != null && parent != null) {
            adj.putIfAbsent(root, new HashSet<>());
            adj.putIfAbsent(parent, new HashSet<>());
            adj.get(root).add(parent);
            adj.get(parent).add(root);
        }
        if(root.left != null) buildGraph(root.left, root, adj);
        if(root.right != null) buildGraph(root.right, root, adj);
    }
}