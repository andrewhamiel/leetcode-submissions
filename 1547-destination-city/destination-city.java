class Solution {
    public String destCity(List<List<String>> paths) {
        //topological sort
        Map<String, GNode> adj = new HashMap<>();
        for(List<String> path : paths){
            adj.putIfAbsent(path.get(0), new GNode());
            adj.putIfAbsent(path.get(1), new GNode());
            adj.get(path.get(0)).outDegrees.add(path.get(1));
            adj.get(path.get(1)).inDegrees++;
        }

        for(String key : adj.keySet()) if(adj.get(key).outDegrees.isEmpty()) return key;
        return "";
    }
    class GNode {
        List<String> outDegrees = new ArrayList<>();
        int inDegrees = 0;
    }
}