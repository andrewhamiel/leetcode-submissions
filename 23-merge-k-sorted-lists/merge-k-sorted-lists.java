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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeK(0, lists.length - 1, lists);
    }

    /*
    * Divide and Conquer
    */
    private ListNode mergeK(int left, int right, ListNode[] lists) {
        if(left >= right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode leftNode = mergeK(left, mid, lists), rightNode = mergeK(mid + 1, right, lists);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(), curr = result;
        while(a != null || b != null) {
            if(a != null && b != null) {
                if(a.val <= b.val) {
                    curr.next = a;
                    a = a.next;
                }else {
                    curr.next = b;
                    b = b.next;
                }
            }else if(a != null) {
                curr.next = a;
                a = a.next;
            }else if(b != null) {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        return result.next;
    }
}