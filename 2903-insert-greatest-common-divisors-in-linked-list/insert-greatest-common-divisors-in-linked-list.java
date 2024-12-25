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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr.next != null) {
            ListNode nextNode = curr.next;

            int gcdVal = calculateGcd(curr.val, nextNode.val);
            ListNode gcd = new ListNode(gcdVal);

            gcd.next = nextNode;
            curr.next = gcd;
            curr = nextNode;
        }
        return head;
    }

    private int calculateGcd(int a, int b) {
        //euclidian algorithm
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}