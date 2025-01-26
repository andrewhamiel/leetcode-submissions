/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //1. Root
        if(!isLeaf(root)) result.add(root.val);
        //2. Left boundary
        leftBoundary(root, result);
        //3. Leaves
        addLeaves(root, result);
        //4. Reverse right boundary
        reverseRightBoundary(root, result);

        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) result.add(curr.val);
            curr = curr.left != null ? curr.left : curr.right;
        }
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if(root == null) return;

        if(isLeaf(root)) result.add(root.val);
        else {
            addLeaves(root.left, result);
            addLeaves(root.right, result);
        }
    }

    private void reverseRightBoundary(TreeNode root, List<Integer> result) {
        Deque<Integer> stack = new ArrayDeque<>();
        TreeNode curr = root.right;
        while(curr != null) {
            if(!isLeaf(curr)) stack.addFirst(curr.val);
            curr = curr.right != null ? curr.right : curr.left;
        }

        while(!stack.isEmpty()) result.add(stack.removeFirst());
    }
}