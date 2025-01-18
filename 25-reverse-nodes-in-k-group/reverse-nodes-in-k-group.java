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
        ListNode curr = head, newHead = null, prevTail = null;
        while(curr != null) {
            //1. Iterate through group
            int size = 0;
            while(curr != null && size < k) {
                curr = curr.next;
                size++;
            }
            //2. Last group remains unchanged if less than k nodes
            if(size == k) {
                //3. Reverse k-group, head will point to last node in curr group
                ListNode reverseHead = reverseK(head, k);
                //4. During first iteration, set new head
                if(newHead == null) newHead = reverseHead;
                //5. Connect group with previous group
                if(prevTail != null) prevTail.next = reverseHead;
                //6. Set prevTail as last node in k group
                prevTail = head;
                //7. Reset head to first node in next k group
                head = curr;
            }
        }
        //8. Connect last two groups together
        if(prevTail != null) prevTail.next = head;

        return newHead;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode curr = head, prev = null;
        while(curr != null && k-- > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}