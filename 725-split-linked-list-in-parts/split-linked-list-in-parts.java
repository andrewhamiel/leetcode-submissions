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
    public ListNode[] splitListToParts(ListNode head, int k) {
        //Find size of linked list
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        int parts = size / k, rem = size % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        for(int i = 0; i < k; i++) {
            ListNode ptr = curr;
            int carry = i < rem ? 1 : 0;
            for(int j = 0; j < parts + carry - 1; j++) {
                //Advance to last node in partition
                if(curr != null) {
                    curr = curr.next;
                }
            }

            //Delink last node if not null
            if(curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            result[i] = ptr;
        }
        return result;
    }
}