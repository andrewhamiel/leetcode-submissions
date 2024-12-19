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
    private List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return result;

        //1. Root
        if(!isLeaf(root)) result.add(root.val);
        //2. Left Boundary
        leftBoundary(root);
        //3. Leaves
        addLeaves(root);
        //4. Reverse Right Boundary
        rightBoundary(root);

        return result;    
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void leftBoundary(TreeNode root) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) result.add(curr.val);
            curr = curr.left != null ? curr.left : curr.right;
        }
    }

    private void addLeaves(TreeNode root) {
        if(isLeaf(root)) result.add(root.val);
        else {
            if(root.left != null) addLeaves(root.left);
            if(root.right != null) addLeaves(root.right);
        } 
    }

    private void rightBoundary(TreeNode root) {
        Deque<Integer> stack = new ArrayDeque<>();
        TreeNode curr = root.right;
        while(curr != null) {
            if(!isLeaf(curr)) stack.addFirst(curr.val);
            curr = curr.right != null ? curr.right : curr.left;
        }
        while(!stack.isEmpty()) result.add(stack.removeFirst());
    }
}