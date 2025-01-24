class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, GNode> adj = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int firstCourse = prerequisite[1], secondCourse = prerequisite[0];
            adj.putIfAbsent(firstCourse, new GNode());
            adj.putIfAbsent(secondCourse, new GNode());
            adj.get(firstCourse).nextCourses.add(secondCourse);
            adj.get(secondCourse).dependencies++;
        }

        Queue<Integer> noDeps = new LinkedList<>();
        for(int course = 0; course < numCourses; course++) if(adj.getOrDefault(course, new GNode()).dependencies == 0) noDeps.add(course);

        Set<Integer> visited = new HashSet<>();

        while(!noDeps.isEmpty()) {
            int currCourse = noDeps.poll();
            visited.add(currCourse);

            for(int nextCourse : adj.getOrDefault(currCourse, new GNode()).nextCourses) {
                adj.get(nextCourse).dependencies--;
                if(adj.get(nextCourse).dependencies == 0) noDeps.add(nextCourse);
            }
        }

        return visited.size() == numCourses;
    }

    class GNode {
        int dependencies = 0;
        List<Integer> nextCourses = new ArrayList<>();
    }
}