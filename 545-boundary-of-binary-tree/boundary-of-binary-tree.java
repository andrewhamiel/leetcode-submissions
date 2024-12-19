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
        if(root == null) return result;

        //1. Add root
        if(!isLeaf(root)) result.add(root.val);
        //2. Left Boundary
        leftBoundary(root, result);

        //3. Leaves
        addLeaves(root, result);

        //4. Reverse right boundary
        rightBoundary(root, result);

        return result;
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) result.add(curr.val);
            curr = curr.left != null ? curr.left : curr.right;
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> result) {
        TreeNode curr = root.right;
        Deque<Integer> stack = new ArrayDeque<>();
        while(curr != null) {
            if(!isLeaf(curr)) stack.addFirst(curr.val);
            curr = curr.right != null ? curr.right : curr.left;
        }
        while(!stack.isEmpty()) result.add(stack.removeFirst());
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if(isLeaf(root)) result.add(root.val);
        else {
            if(root.left != null) addLeaves(root.left, result);
            if(root.right != null) addLeaves(root.right, result);
        }
    }
}