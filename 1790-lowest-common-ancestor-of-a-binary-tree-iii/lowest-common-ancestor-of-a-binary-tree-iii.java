/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pPtr = p, qPtr = q;
        while(pPtr != qPtr) {
            pPtr = pPtr.parent == null ? q : pPtr.parent;
            qPtr = qPtr.parent == null ? p : qPtr.parent;
        }
        return pPtr;
    }
}