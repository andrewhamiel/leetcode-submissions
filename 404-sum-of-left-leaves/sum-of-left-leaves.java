class Solution { 
    
  public int sumOfLeftLeaves(TreeNode root) {
    return processSubtree(root, false);
  }
    
  private int processSubtree(TreeNode subtree, boolean isLeft) {
    
    // Base case: This is an empty subtree.
    if (subtree == null) {
      return 0;
    }
    
    // Base case: This is a leaf node.
    if (subtree.left == null && subtree.right == null) {
      return isLeft ? subtree.val : 0;
    }
    
    // Recursive case: We need to add and return the results of the
    // left and right subtrees.
    return processSubtree(subtree.left, true) + processSubtree(subtree.right, false);
  }
}