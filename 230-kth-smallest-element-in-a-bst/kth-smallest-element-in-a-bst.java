class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> result){
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}