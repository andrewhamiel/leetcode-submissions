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

        while(root != null){
            if(root.left != null){
                Node predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) predecessor = predecessor.right;

                if(predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }else{
                    //already visited
                    if(last != null) last.right = root;
                    root.left = last;
                    last = root;
                    root = root.right;
                }
            }else{
                if(first == null) first = root;
                if(last != null) last.right = root;
                root.left = last;
                last = root;
                root = root.right;
            }
        }

        first.left = last;
        last.right = first;
        return first;
    }
}