class Solution {
    private int rootToLeaf = 0;
    
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    private void preorder(TreeNode r, int curr) {
        if (r == null) return;
        curr = curr * 10 + r.val;
        // if it's a leaf, update root-to-leaf sum
        if (r.left == null && r.right == null) rootToLeaf += curr;
        
        preorder(r.left, curr);
        preorder(r.right, curr) ;
    }
}