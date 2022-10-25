class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    
    //Postorder DFS. Time: O(E + V), E = # dependencies, V = number courses
    //Space: O(E + V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] course : prerequisites){
            map.putIfAbsent(course[1], new ArrayList());
            map.get(course[1]).add(course[0]);
        }
        
        boolean[] path = new boolean[numCourses], checked = new boolean[numCourses];
        for(int[] course : prerequisites) if(isCyclic(course[1], path, checked)) return false;
        return true;
    }
    
    private boolean isCyclic(int course, boolean[] path, boolean[] checked){
        //if we already checked this node, or if key isn't present, no cycle
        if(checked[course] || !map.containsKey(course)) return false;
        //if we have repeated along same path, cycle found
        if(path[course]) return true;
        
        //mark before backtracking
        path[course] = true;
        boolean isCycle = false;
        for(Integer prereq : map.get(course)){
            isCycle = isCyclic(prereq, path, checked);
            if(isCycle) break;
        }
        path[course] = false;
        checked[course] = true;
        return isCycle;
    }
}