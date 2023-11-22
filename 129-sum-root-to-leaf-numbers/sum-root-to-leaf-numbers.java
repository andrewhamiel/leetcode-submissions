class Solution {
  public int sumNumbers(TreeNode root) {
    int rootToLeaf = 0, currNumber = 0;

    while (root != null) {
      if (root.left != null) {
        TreeNode predecessor = root.left;
        int steps = 1;
        while (predecessor.right != null && predecessor.right != root) {
          predecessor = predecessor.right;
          steps++;
        }
        // Set link predecessor.right = root and go to explore the left subtree
        if (predecessor.right == null) {
          currNumber = currNumber * 10 + root.val;
          predecessor.right = root;
          root = root.left;
        } else {
          // Break the link predecessor.right = root
          // Once the link is broken, it's time to change subtree and go to the right
          // If you're on the leaf, update the sum
          if (predecessor.left == null) rootToLeaf += currNumber;
          // This part of tree is explored, backtrack
          for(int i = 0; i < steps; i++) {
            currNumber /= 10;
          }
          predecessor.right = null;
          root = root.right;
        }
      } else {
        // If there is no left child, then just go right.
        currNumber = currNumber * 10 + root.val;
        // if you're on the leaf, update the sum
        if (root.right == null) rootToLeaf += currNumber;
        root = root.right;
      }
    }
    return rootToLeaf;
  }
}