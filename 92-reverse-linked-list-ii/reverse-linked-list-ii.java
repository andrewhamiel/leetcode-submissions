class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Empty list
        if (head == null) return null;

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.        
        while (right > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}