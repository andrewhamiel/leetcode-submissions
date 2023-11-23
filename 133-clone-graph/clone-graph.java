/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
  
        Map<Node, Node> visited = new HashMap();
        visited.put(node, new Node(node.val, new ArrayList()));
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            for (Node neighbor: curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node 
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}