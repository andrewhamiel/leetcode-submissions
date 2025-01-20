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
            //1. Iterate through K-group
            int size = 0;
            while(curr != null && size < k) {
                curr = curr.next;
                size++;
            }

            //2. Final group remains as is if size < k
            if(size == k) {
                //3. Head now points to last node in current k-group
                ListNode reversedHead = reverseK(head, k);
                //4. Set newHead during first iteration
                if(newHead == null) newHead = reversedHead;
                //5. Link previous k-group to current group
                if(prevTail != null) prevTail.next = reversedHead;
                //6. Set tail as last node in curr k-group
                prevTail = head;
                //7. Reset head as first element in next group
                head = curr;
            }
        }

        //8. Link final groups together
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