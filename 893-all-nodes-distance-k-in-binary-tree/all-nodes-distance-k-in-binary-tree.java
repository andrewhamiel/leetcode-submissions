class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {  
        buildGraph(root, null);  
        
        Queue<int[]> queue = new LinkedList<>();     
        // Add the target node to the queue with a distance of 0
        queue.add(new int[]{target.val, 0});
        visited.add(target.val);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], distance = cur[1];
            
            // If the current node is at distance k from target,
            // add it to the answer list and continue to the next node.
            if (distance == k) {
                result.add(node);
                continue;
            }
            
            // Add all unvisited neighbors of the current node to the queue.
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        
        return result;
    }
    
    // Recursively build the undirected graph from the given binary tree.
    private void buildGraph(TreeNode cur, TreeNode parent) {
        if (cur != null && parent != null) {
            int curVal = cur.val, parentVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parentVal, new ArrayList<>());
            graph.get(curVal).add(parentVal);
            graph.get(parentVal).add(curVal);
        }
        
        if (cur != null && cur.left != null) buildGraph(cur.left, cur);
        if (cur != null && cur.right != null) buildGraph(cur.right, cur);
    }
}