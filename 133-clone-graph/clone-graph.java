/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(map.containsKey(node)) return map.get(node);

        Node copyNode = new Node(node.val);
        map.put(node, copyNode);

        for(Node neighbor : node.neighbors) {
            copyNode.neighbors.add(map.getOrDefault(neighbor, cloneGraph(neighbor)));
        }    
        return map.get(node);
    }
}