/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = findCycle(head);
        if(tortoise == null) return null;

        ListNode hare = head;
        while(tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }

    private ListNode findCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare) return tortoise;
        }
        return null; //no cycle
    }
}