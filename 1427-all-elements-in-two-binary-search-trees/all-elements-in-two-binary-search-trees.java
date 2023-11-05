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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr1 = root1, curr2 = root2;
        while(curr1 != null && curr2 != null){
            //Condition morris
            while(curr1.left != null){
                TreeNode tmp = curr1.left;
                while(tmp.right != null && tmp.right != curr1) tmp = tmp.right;

                if(tmp.right == null){
                    tmp.right = curr1;
                    curr1 = curr1.left;
                }else break; //Connection already established
            }
            while(curr2.left != null){
                TreeNode tmp = curr2.left;
                while(tmp.right != null && tmp.right != curr2) tmp = tmp.right;

                if(tmp.right == null){
                    tmp.right = curr2;
                    curr2 = curr2.left;
                }else break;
            }

            //Compare
            if(curr1.val <= curr2.val) {
                result.add(curr1.val);
                curr1 = curr1.right;
            }else{
                result.add(curr2.val);
                curr2 = curr2.right;
            }
        }
        //If one tree is larger than the other, add elements in those trees as well
        inorderTraversalUsingMorris(curr1, result);
        inorderTraversalUsingMorris(curr2, result);
        return result;
    }

    private void inorderTraversalUsingMorris(TreeNode root, List<Integer> result){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode tmp = curr.left;
                while(tmp.right != null && tmp.right != curr) tmp = tmp.right;

                if(tmp.right == null){
                    tmp.right = curr;
                    curr = curr.left;
                }else{
                    tmp.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }else{
                result.add(curr.val);
                curr = curr.right;
            }
        }
    }
}