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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //in order traversal gives you original array
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        //append to array
        arr.add(val);
        //construct max binary tree
        TreeNode result = construct(0, arr.size(), arr);
        return result; 
    }

    private TreeNode construct(int left, int right, List<Integer> nums) {
        if(left == right) return null;
        int maxInd = getMaxInd(left, right, nums);
        TreeNode node = new TreeNode(nums.get(maxInd));
        node.left = construct(left, maxInd, nums);
        node.right = construct(maxInd + 1, right, nums);
        return node;
    }

    private int getMaxInd(int left, int right, List<Integer> nums) {
        int maxInd = left;
        for(int i = left; i < right; i++) {
            if(nums.get(i) > nums.get(maxInd))maxInd = i;
        }
        return maxInd;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}