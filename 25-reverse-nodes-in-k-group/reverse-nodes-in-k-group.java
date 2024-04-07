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
        ListNode curr = head, newHead = null, kTail = null;
        while(curr != null){
            int count = 0;
            while(curr != null && count < k){
                curr = curr.next;
                count++;
            }
            if(count == k){
                ListNode reverseHead = reverse(head, k);
                if(newHead == null) newHead = reverseHead;
                if(kTail != null) kTail.next = reverseHead;
                kTail = head;
                head = curr;
            }
        }
        if(kTail != null) kTail.next = head;
        return newHead;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode curr = head, prev = null;
        while(k-- > 0){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}