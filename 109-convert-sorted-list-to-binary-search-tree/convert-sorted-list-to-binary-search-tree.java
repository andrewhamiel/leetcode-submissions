/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        //1. Find size of linked list
        curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        //2. Divide and Conquer/Inorder traversal    
        curr = head;
        TreeNode result = divideAndConquer(0, size);
        return result;
    }

    private TreeNode divideAndConquer(int left, int right) {
        if(left >= right) return null;

        //Inorder traversal 
        TreeNode root = new TreeNode();
        int mid = left + (right - left)/2;
        //left 
        root.left = divideAndConquer(left, mid);
        //root
        root.val = curr.val;
        curr = curr.next;
        //right 
        root.right = divideAndConquer(mid + 1, right);

        return root;
    }
}