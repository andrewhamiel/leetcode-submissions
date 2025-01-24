/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //1. Base case: if root  is null
        if(root == null) return null;
        //2. Level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        

        //BFS
        while(!q.isEmpty()) {
            //Iterate level by level
            Node prev = null;
            int size = q.size();
            while(size-- > 0) {
                Node curr = q.poll();
                if(prev != null) prev.next = curr;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
//q: [], size = 1, prev = 7, curr = 7
                prev = curr;
            }
        }
        return root;
    }
}