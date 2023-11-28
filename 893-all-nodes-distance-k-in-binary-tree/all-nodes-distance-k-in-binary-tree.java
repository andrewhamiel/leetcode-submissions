class Solution {
    Map<Integer, List<Integer>> graph;
    List<Integer> answer;
    Set<Integer> visited;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
        
        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);
        
        dfs(target.val, 0, k);
        
        return answer;
    }
    
    // Recursively build the undirected graph from the given binary tree.
    private void buildGraph(TreeNode curr, TreeNode parent) {
        if (curr != null && parent != null) {
            graph.putIfAbsent(curr.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(curr.val).add(parent.val);
            graph.get(parent.val).add(curr.val);
        }

        if (curr.left != null) buildGraph(curr.left, curr);
        if (curr.right != null) buildGraph(curr.right, curr);
    }
    
    private void dfs(int cur, int distance, int k) {
        if (distance == k) {
            answer.add(cur);
            return;
        }

        for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }
}