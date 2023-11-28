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

    private void buildGraph(TreeNode curr, TreeNode parent){
        if(curr != null && parent != null){
            graph.putIfAbsent(curr.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(curr.val).add(parent.val);
            graph.get(parent.val).add(curr.val);
        }

        if(curr.left != null) buildGraph(curr.left, curr);
        if(curr.right != null) buildGraph(curr.right, curr);
    }
}