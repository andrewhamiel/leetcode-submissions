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
        Map<TreeNode, Set<TreeNode>> adj = buildGraph(root);

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

    private Map<TreeNode, Set<TreeNode>> buildGraph(TreeNode root) {
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            adj.putIfAbsent(curr, new HashSet<>());

            if(curr.left != null) {
                adj.putIfAbsent(curr.left, new HashSet<>());
                adj.get(curr).add(curr.left);
                adj.get(curr.left).add(curr);
                q.add(curr.left);
            }
            if(curr.right != null) {
                adj.putIfAbsent(curr.right, new HashSet<>());
                adj.get(curr).add(curr.right);
                adj.get(curr.right).add(curr);
                q.add(curr.right);
            }
        }
        return adj;
    }
}