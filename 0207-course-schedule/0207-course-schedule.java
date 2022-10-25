


class Solution {
    
class GNode {
  int inDegrees = 0;
  List<Integer> outNodes = new ArrayList();
}
    
    // course -> list of next courses
    Map<Integer, GNode> graph = new HashMap();

  public boolean canFinish(int numCourses, int[][] prerequisites) {
// no cycle could be formed in empty graph.
    if (prerequisites.length == 0) return true;  

    // build the graph first
    for (int[] relation : prerequisites) {
      // relation[1] -> relation[0]
      GNode prevCourse = getCreateGNode(relation[1]), nextCourse = getCreateGNode(relation[0]);
      prevCourse.outNodes.add(relation[0]);
      nextCourse.inDegrees++;
    }

    // We start from courses that have no prerequisites.
    int totalDeps = prerequisites.length;
    Queue<Integer> noDepCourses = new LinkedList();
      
    for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
      GNode node = entry.getValue();
      if (entry.getValue().inDegrees == 0) noDepCourses.add(entry.getKey());
    }

      //Remove in edges
    int removedEdges = 0;
    while (noDepCourses.size() > 0) {
      Integer course = noDepCourses.poll();

      for (Integer nextCourse : graph.get(course).outNodes) {
        GNode childNode = graph.get(nextCourse);
        graph.get(nextCourse).inDegrees--;
        removedEdges++;
        if(childNode.inDegrees == 0) noDepCourses.add(nextCourse);
      }
    }
        // if there are still some edges left, then there exist some cycles
      // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
      return removedEdges == totalDeps ? true : false;
  }

  /**
   * Retrieve the existing <key, value> from graph, otherwise create a new one.
   */
  private GNode getCreateGNode(Integer course) {
      if (graph.containsKey(course)) return graph.get(course);
      graph.put(course, new GNode());
      return graph.get(course);
  }
}