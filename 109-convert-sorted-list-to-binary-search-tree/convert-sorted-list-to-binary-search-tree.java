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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        return divideAndConquer(0, list.size() - 1, list);
    }

    private TreeNode divideAndConquer(int left, int right, List<Integer> list) {
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = divideAndConquer(left, mid - 1, list);
        node.right = divideAndConquer(mid + 1, right, list);
        return node;
    }
}