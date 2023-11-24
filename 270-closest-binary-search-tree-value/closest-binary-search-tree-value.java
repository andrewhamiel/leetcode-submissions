class Solution {
  //Time: O(H) -> Height of tree
  //Space: O(1)
  public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    while (root != null) {
      int val = root.val;
      if((Math.abs(val - target) < Math.abs(closest - target))
        || (Math.abs(val - target) == Math.abs(closest - target) && val < closest)) closest = val;

      root =  target < root.val ? root.left : root.right;
    }
    return closest;
  }
}
