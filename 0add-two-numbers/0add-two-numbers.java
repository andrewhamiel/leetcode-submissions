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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), prev = head;
        int one = 0, two = 0, carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int sum = l1.val + l2.val + carry;
                carry = sum >= 10 ? 1 : 0;
                sum%=10;
                head.next = new ListNode(sum);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                int sum = l1.val + carry;
                carry = sum >= 10 ? 1 : 0;
                sum%=10;
                head.next = new ListNode(sum);
                head = head.next;
                l1 = l1.next;
            }else if(l2 != null){
                int sum = l2.val + carry;
                carry = sum >= 10 ? 1 : 0;
                sum%=10;
                head.next = new ListNode(sum);
                head = head.next;
                l2 = l2.next;
            }
        }
        if(carry != 0) head.next = new ListNode(carry);
        return prev.next;
    }
}