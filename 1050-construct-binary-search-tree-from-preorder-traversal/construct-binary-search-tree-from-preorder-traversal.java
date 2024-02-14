class Solution {
  int idx = 0;
  int[] preorder;
  int n;

  public TreeNode bstFromPreorder(int[] preorder) {
    this.preorder = preorder;
    n = preorder.length;
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public TreeNode helper(int lower, int upper) {
    int tmpIndex = idx;
    if (idx == n) return null;

    int val = preorder[idx];

    if (val < lower || val > upper) return null;

    //Place the current element
    // and recursively construct subtrees
    idx++;
    TreeNode root = new TreeNode(val);
    root.left = helper(lower, val);
    root.right = helper(val, upper);
    return root;
  }

  
}