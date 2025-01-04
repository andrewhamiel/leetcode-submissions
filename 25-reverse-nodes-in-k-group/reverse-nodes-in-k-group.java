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
            //1. Advance K nodes
            int count = 0;
            while(curr != null && count < k) {
                curr = curr.next;
                count++;
            }
            //2. Last group remains as is if size < k
            if(count == k) {
                //3. Head is delinked -> becomes last node in reversed group
                ListNode reversedHead = reverseK(head, k);
                //4. Set new head after reversing first K group
                if(newHead == null) newHead = reversedHead;
                //5. Connect previous groups to K group just reversed
                if(prevTail != null) prevTail.next = reversedHead;
                //6. Set tail as last element in reversed K group
                prevTail = head;
                //7. Reset head to beginning of next K group
                head = curr;
            }
        }
        //Link final groups together
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