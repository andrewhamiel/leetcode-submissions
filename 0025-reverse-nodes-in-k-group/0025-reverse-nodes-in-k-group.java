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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, k_tail = null, new_head = null;
        while(curr != null){
            int count = 0;
            while(curr != null && count < k){
                curr = curr.next;
                count++;
            }
            if(count == k){
                ListNode curr_rev = reverse(head, k);
                if(new_head == null) new_head = curr_rev;
                if(k_tail != null) k_tail.next = curr_rev;
                
                k_tail = head;
                head = curr;
            }
        }
        if(k_tail != null) k_tail.next = head;
        return new_head;
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode curr = head, prev = null;
        while(k-- > 0){
            ListNode next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        return prev;
    }
}