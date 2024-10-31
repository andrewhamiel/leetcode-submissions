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
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        this.head = head;

        //1. Find size 
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }    

        //2. Inorder traversal 
        return divideAndConquer(0, size - 1);
    }

    private TreeNode divideAndConquer(int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode();
        //Left 
        root.left = divideAndConquer(left, mid - 1);
        //Root 
        root.val = head.val;
        //Right 
        head = head.next;
        root.right = divideAndConquer(mid + 1, right);
        
        return root;
    }
}