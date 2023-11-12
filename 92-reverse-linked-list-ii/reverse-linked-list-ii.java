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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;
        
        ListNode curr = head, prev = null;
        while(left-- > 1){
            prev = curr;
            curr = curr.next;
            right--;
        }

        ListNode connecting = prev, tail = curr;
        while(right-- > 0){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        if(connecting != null) connecting.next = prev;
        else head = prev;

        tail.next = curr;
        return head;
    }
}