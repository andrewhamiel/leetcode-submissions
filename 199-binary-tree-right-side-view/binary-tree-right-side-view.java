class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList(){{ offer(root); offer(null); }};
        TreeNode prev, curr = root;
        List<Integer> rightside = new ArrayList();
        
        while (!q.isEmpty()) {
            prev = curr;
            curr = q.poll();

            while (curr != null) {
                // add child nodes in the queue
                if (curr.left != null) q.offer(curr.left);    

                if (curr.right != null) q.offer(curr.right);
                
                prev = curr;
                curr = q.poll();
            }      

            // the current level is finished
            // and prev is its rightmost element
            rightside.add(prev.val);
            // add a sentinel to mark the end
            // of the next level
            if (!q.isEmpty())
                q.offer(null);
        }
        return rightside;
    }
}