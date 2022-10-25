class Solution {
    class GNode{
        int inDegrees = 0;
        List<Integer> outNodes = new ArrayList();
    }
    
    Map<Integer, GNode> graph = new HashMap();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        
        //Build adjacency graph
        for(int[] course : prerequisites){
            GNode prevCourse = getGNode(course[1]), nextCourse = getGNode(course[0]);
            prevCourse.outNodes.add(course[0]);
            nextCourse.inDegrees++;
        }
        
        //Find courses with no dependencies
        Queue<Integer> noDeps = new LinkedList();
        for(Map.Entry<Integer, GNode> entry : graph.entrySet()){
            if(entry.getValue().inDegrees == 0) noDeps.offer(entry.getKey());
        }
        
        int removedNodes = 0;
        while(noDeps.size() > 0){
            Integer course = noDeps.poll();
            for(Integer nextCourse : graph.get(course).outNodes){
                graph.get(nextCourse).inDegrees--;
                removedNodes++;
                if(graph.get(nextCourse).inDegrees == 0) noDeps.add(nextCourse);       
            }
        }      
            
        return removedNodes == prerequisites.length ? true : false;
    }
    
    private GNode getGNode(int course){
        graph.putIfAbsent(course, new GNode());
        return graph.get(course);
    }
}