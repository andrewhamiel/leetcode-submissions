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
        int pDepth = getDepth(p), qDepth = getDepth(q);

        while(pDepth > qDepth) {
            p = p.parent;
            pDepth--;
        }

        while(qDepth > pDepth) {
            q = q.parent;
            qDepth--;
        }

        while(p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    private int getDepth(Node p) {
        Node curr = p;
        int depth = 1;
        while(curr.parent != null) {
            curr = curr.parent;
            depth++;
        }
        return depth;
    }
}