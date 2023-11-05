class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int numSimilarGroups(String[] strs) {
        //Build adjacency graph
        for(int i = 0; i < strs.length; i++){
            for(int j = i + 1; j < strs.length; j++){
                if(isSimilar(strs[i], strs[j])){
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.putIfAbsent(j, new ArrayList<>());
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        //Count connected components
        int count = 0;
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    private boolean isSimilar(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 0 || diff == 2;
    }

    private void dfs(int node, boolean[] visited){
        visited[node] = true;
        if(!adj.containsKey(node)) return;
        for(int component : adj.get(node)){
            if(!visited[component]){
                visited[component] = true;
                dfs(component, visited);
            }
        }
    }
}