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
    Node ans;

    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = findRoot(p);
        isSubtree(p, q, root);
        return ans;
    }

    private Node findRoot(Node p){
        Node root = p;
        while(root.parent != null) root = root.parent;
        return root;
    }

    private boolean isSubtree(Node p, Node q, Node curr){
        if(curr == null) return false;
        int left = isSubtree(p, q, curr.left) ? 1 : 0;
        int right = isSubtree(p, q, curr.right) ? 1 : 0;
        int mid = (curr.val == p.val || curr.val == q.val) ? 1 : 0;
        if(left + right + mid >= 2) ans = curr;
        return left + right + mid > 0;
    }


}