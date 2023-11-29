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
    //better, morris traversal, O(1) space
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node first = null, last = null;
    
        while(root != null){       
            if(root.left == null){
                if(first == null) first = root;
                //do something
                if(last != null) last.right = root;
                root.left = last;
                last = root;
                //explore right subtree
                root = root.right;           
            }else {
                Node predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) predecessor = predecessor.right;

                if(predecessor.right == root){
                    //done exploration of left tree               
                    //do something
                    if(last != null) last.right = root;
                    root.left = last;
                    last = root;             
                    //explore right subtree
                    root = root.right;            
                }else{
                    predecessor.right = root;
                    root = root.left;
                }      
            }        
        }

        last.right = first;
        first.left = last;     
        return first; 
    }
}