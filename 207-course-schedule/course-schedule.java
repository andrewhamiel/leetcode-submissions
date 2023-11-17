class Solution {
    Map<Integer, GNode> adj = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1. Build adjacencies
        for(int[] course : prerequisites){
            GNode prevCourse = getGNode(course[1]), nextCourse = getGNode(course[0]);
            prevCourse.outDegrees.add(course[0]);
            nextCourse.inDegrees++;
        }
        //2. Find courses with no dependencies
        Queue<Integer> noDeps = new LinkedList<>();
        for(Map.Entry<Integer, GNode> entry : adj.entrySet()){
            Integer course = entry.getKey();
            GNode node = entry.getValue();
            if(node.inDegrees == 0) noDeps.add(course);
        }
        //3. Topological Sort to remove dependencies
        int dependenciesRemoved = 0;
        while(!noDeps.isEmpty()){
            Integer course = noDeps.poll();
            for(Integer nextCourse : adj.get(course).outDegrees){
                GNode node = adj.get(nextCourse);
                node.inDegrees--;
                dependenciesRemoved++;
                if(node.inDegrees == 0) noDeps.add(nextCourse);
            }
        }
        return dependenciesRemoved == prerequisites.length;
    }

    private GNode getGNode(int course){
        adj.putIfAbsent(course, new GNode());
        return adj.get(course);
    }

    class GNode {
        int inDegrees = 0;
        List<Integer> outDegrees = new ArrayList<>();
    }
}