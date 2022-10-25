class Solution {
    class GNode{
        int inDegrees = 0;
        List<Integer> outNodes = new ArrayList();
    }
    
    private Map<Integer, GNode> graph = new HashMap();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return computeEmptyPrereqs(numCourses);
        
        
        //Build adjacency graph
        for(int[] course : prerequisites){
            GNode prevNode = getGNode(course[1]), nextNode = getGNode(course[0]);
            prevNode.outNodes.add(course[0]);
            nextNode.inDegrees++;
        }
        
        //Identify courses with no dependencies as starting point
        Queue<Integer> noDeps = new LinkedList();
        for(Map.Entry<Integer, GNode> entry : graph.entrySet()){
            if(entry.getValue().inDegrees == 0){
                noDeps.add(entry.getKey());
            } 
        }
            
        Set<Integer> seen = new HashSet();
        List<Integer> result = new ArrayList();
        //compute result
        int removedEdges = 0;
        while(!noDeps.isEmpty()){
            Integer course = noDeps.poll();
            result.add(course);
            
            
            for(Integer nextCourse : graph.get(course).outNodes){
                graph.get(nextCourse).inDegrees--;
                removedEdges++;
                if(graph.get(nextCourse).inDegrees == 0){
                    noDeps.add(nextCourse);
                    
                } 
            }
            seen.add(course);
            graph.remove(course);
        }
        
        
        return graph.size() == 0 ? computeResult(result, numCourses, seen) : new int[0];
    }
    
    private GNode getGNode(int course){
        graph.putIfAbsent(course, new GNode());
        return graph.get(course);
    }
    
    private int[] computeResult(List<Integer> result, int numCourses, Set<Integer> seen){
        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses && result.size() != numCourses; i++) if(!seen.contains(i)) result.add(i);
        for(int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
    
    private int[] computeEmptyPrereqs(int numCourses){
        int[] ans = new int[numCourses];
        for(int i = 0; i < ans.length; i++) ans[i] = i;
        return ans;
    }
}