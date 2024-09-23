class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, GNode> adj = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            adj.putIfAbsent(prerequisite[0], new GNode());
            adj.putIfAbsent(prerequisite[1], new GNode());
            adj.get(prerequisite[0]).indegrees++;
            adj.get(prerequisite[1]).outdegrees.add(prerequisite[0]);
        }

        Queue<Integer> noPrereqs = new LinkedList<>();
        for(int key : adj.keySet()) if(adj.get(key).indegrees == 0) noPrereqs.add(key);
        Set<Integer> visited = new HashSet<>();

        while(!noPrereqs.isEmpty()){
            int course = noPrereqs.poll();
            visited.add(course);
            for(int nextCourse : adj.get(course).outdegrees){
                GNode nextNode = adj.get(nextCourse);
                nextNode.indegrees--;
                if(nextNode.indegrees == 0) noPrereqs.add(nextCourse); 
            }
        }
        return visited.size() == adj.keySet().size();
    }

    class GNode {
        List<Integer> outdegrees = new ArrayList<>();
        int indegrees = 0;
    }
}