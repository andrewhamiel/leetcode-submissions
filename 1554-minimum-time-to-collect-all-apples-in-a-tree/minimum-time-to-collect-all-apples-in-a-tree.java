class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        return dfs(0, -1, hasApple, adj);
    }

    private int dfs(int child, int parent, List<Boolean> hasApple, Map<Integer, List<Integer>> adj) {
        if(!adj.containsKey(child)) return 0;

        int totalTime = 0;
        for(int nextNode : adj.get(child)) {
            if(nextNode == parent) continue;
            int childTime = dfs(nextNode, child, hasApple, adj);
            if(childTime > 0 || hasApple.get(nextNode)) totalTime+= 2 + childTime; //Visiting and returning takes 2 units of time
        }
        return totalTime;
    } 
}