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
        Node root = findParent(p);
        return lca(root, p, q);
    }

    private Node findParent(Node p){
        Node curr = p;
        while(curr.parent != null) curr = curr.parent;
        return curr;
    }

    private Node lca(Node root, Node p, Node q){
        if(root == null) return root;

        if(root == p || root == q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}