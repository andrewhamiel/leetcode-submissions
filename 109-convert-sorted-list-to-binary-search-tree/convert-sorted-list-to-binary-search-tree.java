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
        //1. Find list of size
        int size = 0;
        curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        //2. Divide/Conquer in order traversal
        curr = head;
        TreeNode result = divideAndConquer(0, size);
        return result;
    }

    private TreeNode divideAndConquer(int left, int right) {
        if(left >= right) return null;

        //In order 
        TreeNode root = new TreeNode();
        int mid = left + (right - left)/2;
        root.left = divideAndConquer(left, mid);

        root.val = curr.val;
        curr = curr.next;

        root.right = divideAndConquer(mid + 1, right);

        return root;
    }
}