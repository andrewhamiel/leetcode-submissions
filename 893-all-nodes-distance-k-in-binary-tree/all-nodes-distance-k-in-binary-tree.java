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
    private Map<TreeNode, List<TreeNode>> adj = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);    

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(distance == k) result.add(curr.val);

                for(TreeNode nextNode : adj.getOrDefault(curr, new ArrayList<>())) {
                    if(!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        q.add(nextNode);
                    }
                }
            }
            distance++;
        }
        return result;
    }

    private void buildGraph(TreeNode child, TreeNode parent) {
        if(parent != null) {
            adj.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
            adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }
        if(child.left != null) buildGraph(child.left, child);
        if(child.right != null) buildGraph(child.right, child);
    }
}