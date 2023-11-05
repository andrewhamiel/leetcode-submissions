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
    /** 
        2. Lets dicsuss Morris law inorder traversal
            1. First we will go to the most left of tree1 and tree2
            2. compare both value, consider the smaller one, move to the right whhich value has been considered
            3. do step 1 and 2 till both are not null
            4. one of them null, break the loop
            5. Do morris inorder traversal for the one which is remaining

        Time complexity: O(n + m), as we need to traversal both the tree
        Space complexity: O(1), Note: Here we are not considering the output array
    */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return getAllElementsUsingMorrisLaw(root1, root2);
    }

    private List<Integer> getAllElementsUsingMorrisLaw(TreeNode root1, TreeNode root2) {
        TreeNode current1 = root1;
        TreeNode current2 = root2;

        List<Integer> result = new ArrayList<>();

        // if both are not null
        while(current1 != null && current2 != null) {
            // go to left most
            // while going make the connection 
            while(current1.left != null) {
                TreeNode temp = current1.left;

                // go to most right 
                while(temp.right != null && temp.right != current1) {
                    temp = temp.right;
                }
                // if the connection is not there
                // make the connection
                // move current to current left
                if(temp.right == null) {
                    temp.right = current1;
                    current1 = current1.left;
                }
                // if the connection is already present
                // means we have already considered
                // do nothing
                else {
                    // temp.right = null;
                    break;
                }
            }
            // go to left most
            // while going make the connetion
            while(current2.left != null) {
                TreeNode temp = current2.left;

                // go to most right
                while(temp.right != null && temp.right != current2) {
                    temp = temp.right;
                }

                // if the connection is not present
                // make the connection
                // move current to current left
                if(temp.right == null) {
                    temp.right = current2;
                    current2 = current2.left;
                }

                // if the connection is already present
                // means we have already considered 
                // do nothing
                else {
                    // temp.right = null;
                    break;
                }
            }
            // compare both the value
            // add to the list
            // move the pointer to the right whichever have considered
            if(current1.val <= current2.val) {
                result.add(current1.val);
                current1 = current1.right;
            } else {
                result.add(current2.val);
                current2 = current2.right;
            }
        }

        // if first tree node are remaining
        // traverse the tree and collect all values
        inorderTraversalUsingMorris(current1, result);
        // if second tree node are remaining, 
        // traverse the tree and collect all values
        inorderTraversalUsingMorris(current2, result);

        return result;
    }


    private void inorderTraversalUsingMorris(TreeNode root, List<Integer> inorder) {
        TreeNode current = root;
        while(current != null) {
            if(current.left == null) {
                inorder.add(current.val);
                current = current.right;
            } else {
                TreeNode temp = current.left;
                while(temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
    }
}