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
        Node parent = findParent(p);
        lca(parent, p, q);
        return ans;
    }

    private Node findParent(Node p){
        Node node = p;
        while(node.parent != null) node = node.parent;
        return node;
    }

    private boolean lca(Node root, Node p, Node q){
        if(root == null) return false;
        int sum = root.val == p.val || root.val == q.val ? 1 : 0;
        int left = lca(root.left, p, q) ? 1 : 0;
        int right = lca(root.right, p, q) ? 1 : 0;
        if(sum + left + right >= 2) ans = root;
        return sum + left + right >= 1;
    }
}