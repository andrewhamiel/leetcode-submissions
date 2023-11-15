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

    private Node findParent(Node node){
        Node root = node;
        while(root.parent != null) root = root.parent;
        return root;
    }

    private Node lca(Node root, Node p, Node q){
        if(root == null) return null;

        if(root == p || root == q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}