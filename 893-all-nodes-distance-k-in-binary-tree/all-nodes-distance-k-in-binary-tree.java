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
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);
        visited.add(target.val);
        dfs(target.val, 0, k);
        return result;
    }

    private void dfs(int curr, int distance, int k){
        if(distance == k){
            result.add(curr);
            return;
        }

        for(int neighbor : graph.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }

    private void buildGraph(TreeNode root, TreeNode parent){
        if(root != null && parent != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }

        if(root.left != null) buildGraph(root.left, root);
        if(root.right != null) buildGraph(root.right, root);
    }
}