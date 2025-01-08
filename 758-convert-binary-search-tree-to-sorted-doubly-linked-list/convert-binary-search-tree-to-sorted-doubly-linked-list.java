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
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node first = null, last = null;

        //Morris inorder traversal
        while(root != null) {
            if(root.left != null) {
                Node predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) predecessor = predecessor.right;

                if(predecessor.right == null) {
                    //Unexplored
                    predecessor.right = root;
                    root = root.left;
                }else {
                    //Link last and root
                    if(last != null) last.right = root;
                    root.left = last;
                    last = root;
                    root = root.right;
                }
            }else {
                //First iteration that root.left is null must be min element
                if(first == null) first = root;
                //Link last and root
                if(last != null) last.right = root;
                root.left = last;
                last = root;
                root = root.right;
            }
        }

        //Make circular
        first.left = last;
        last.right = first;
        return first;
    }
}