class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;

        Map<Integer, GNode> adj = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int firstCourse = prerequisite[1], secondCourse = prerequisite[0];
            adj.putIfAbsent(firstCourse, new GNode());
            adj.putIfAbsent(secondCourse, new GNode());
            adj.get(firstCourse).nextCourses.add(secondCourse);
            adj.get(secondCourse).dependencies++;
        }

        Queue<Integer> noDeps = new ArrayDeque<>();
        for(int course : adj.keySet()) if(adj.get(course).dependencies == 0) noDeps.add(course);

        int coursesTaken = 0;

        while(!noDeps.isEmpty()) {
            int currCourse = noDeps.poll();
            coursesTaken++;

            for(int nextCourse : adj.getOrDefault(currCourse, new GNode()).nextCourses) {
                adj.get(nextCourse).dependencies--;
                if(adj.get(nextCourse).dependencies == 0) noDeps.add(nextCourse);
            }
        }
        return coursesTaken == adj.size();
    }

    class GNode {
        int dependencies = 0;
        List<Integer> nextCourses = new ArrayList<>();
    }
}