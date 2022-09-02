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
    List<Double> result = new ArrayList();
    Map<Integer, Integer> map = new HashMap();
    public List<Double> averageOfLevels(TreeNode root) {
        int height = 0;
        traverseHeight(root, 0);
        return result;
    }
    
    private void traverseHeight(TreeNode root, int height){
        Map<Integer, Integer> tmp = map;
        if(root == null) return;
        if(height == result.size()){
            result.add(Double.valueOf((double)root.val));
            map.put(height, 1);
        } 
        else{
            Double avg = result.get(height);
            Integer nums = map.remove(height);
            avg = ((avg*nums)+root.val)/(nums+1);
            map.put(height, nums+1);
            result.set(height, avg);
        }
        if(root.left != null) traverseHeight(root.left, height+1);
        if(root.right != null) traverseHeight(root.right, height+1);
    }
}