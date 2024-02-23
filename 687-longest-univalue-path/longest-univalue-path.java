// Returns the length of the longest path (number of nodes) under the root
// that have the value same as the root. The path could either be
// on the left or right child of the root. The length includes the root as well.
class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        solve(root, -1);
        return ans;
    }

    int solve(TreeNode root, int parent) {
        if (root == null)  return 0; 

        int left = solve(root.left, root.val);
        int right = solve(root.right, root.val);

        ans = Math.max(ans, left + right);

        return root.val == parent ? Math.max(left, right) + 1 : 0;
    }
}