/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private Node first, last;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void helper(Node node){
        if(node == null) return;
        helper(node.left);
        if(last != null){
            last.right = node;
            node.left = last;
        }else first = node;
        last = node;
        helper(node.right);
    }
}