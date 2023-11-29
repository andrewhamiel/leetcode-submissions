class Solution {
    public Node treeToDoublyList(Node root) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Node cur = root, head = null, tail = null, tmp;
        // morris' algo
        while (cur != null) {
            head = cur.val < min ? cur : head;
            min = Math.min(min, cur.val);
            tail = cur.val > max ? cur : tail;
            max = Math.max(max, cur.val);
            // right most on left subtree
            Node rlmost = cur.left;
            while (rlmost != null
                   && rlmost.right != null && rlmost != cur) {
                rlmost = rlmost.right;
            }
            tmp = cur.left;
            if (rlmost != null && rlmost != cur) {
                // link rlmost node and cur
				// if still can go left then go
                rlmost.right = cur;
                cur.left = rlmost;
                cur = tmp;
                continue;
            }
            // no left substree or linked before, go right
			// find the left most node of right subtree
            Node lrmost = cur.right;
            while (lrmost != null
                   && lrmost.left != null && lrmost.left != cur) {
                // note that if lrmost.left (lrmost.pre) is cur
                // which means cur and lrmost are already in linked list
                // then just skip
                lrmost = lrmost.left;
            }
            tmp = cur.right;
            if (lrmost != null && lrmost.left != cur) {
                lrmost.left = cur;
                cur.right = lrmost;
            }
            cur = tmp;
        }
        // cyclic linking
        if (head != null) {
            tail.right = head;
            head.left = tail;
        }
        return head;
    }
}