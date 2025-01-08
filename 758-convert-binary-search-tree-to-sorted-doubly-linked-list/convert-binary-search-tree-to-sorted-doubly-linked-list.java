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
    Node first = null, last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;      
        
        inorder(root);
        
        //Make circular
        first.left = last;
        last.right = first;
        return first;
    }

    private void inorder(Node root) {
        if(root == null) return;
        //Left
        inorder(root.left);
        //Root 
        if(first == null) first = root;
        else {
            last.right = root;
            root.left = last;
        }
        last = root;
        //Right
        inorder(root.right);
    }
}