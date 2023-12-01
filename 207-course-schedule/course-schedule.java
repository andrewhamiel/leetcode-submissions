class Solution {
    class GNode {
        List<Integer> outDegrees = new ArrayList<>();
        int inDegrees = 0;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1. Build adjacencies
        Map<Integer, GNode> adj = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            int nextCourse = prerequisite[0], prevCourse = prerequisite[1];
            adj.putIfAbsent(nextCourse, new GNode());
            adj.putIfAbsent(prevCourse, new GNode());
            adj.get(nextCourse).inDegrees++;
            adj.get(prevCourse).outDegrees.add(nextCourse);
        }

        //2. Find courses without dependencies
        Queue<Integer> q = new LinkedList<>();
        for(int course : adj.keySet()) if(adj.get(course).inDegrees == 0) q.add(course);

        //3. Topological sort
        int coursesRemoved = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nextCourse : adj.get(curr).outDegrees){
                adj.get(nextCourse).inDegrees--;
                coursesRemoved++;
                if(adj.get(nextCourse).inDegrees == 0) q.add(nextCourse);
            }
        }
        //4. Validate all prerequisites removed
        return coursesRemoved == prerequisites.length;
    }
}