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
        if(root==null) return root;
        Node cur=root, head=null, prev=null;
    
        while(cur!=null){       
            if(cur.left==null){
                if(head==null)head=cur;
                //do something
                if(prev!=null) prev.right=cur;
                cur.left=prev;
                prev=cur;
                //explore right subtree
                cur=cur.right;           
            }else {
                Node pred= findPredecessor(cur);

                if(pred.right==cur){
                    //done exploration of left tree               
                    //do something
                    if(prev!=null) prev.right=cur;
                    cur.left=prev;
                    prev=cur;             
                    //explore right subtree
                    cur=cur.right;            
                }else{
                    pred.right=cur;
                    cur=cur.left;
                }      
            }        
        }
        prev.right=head;
        head.left=prev;
        
        return head; 
    }

    public Node findPredecessor(Node node){
        Node cur=node;
        if(cur.left==null) return null;
        
        cur=cur.left;
        while(cur.right!=null&&cur.right!=node) cur=cur.right;

        return cur;
    }

}