/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        //1
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode curr = stack.removeFirst();
            
            if(curr.left != null){
                parent.put(curr.left, curr);
                stack.addFirst(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                stack.addFirst(curr.right);
            }
        }

        //2
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        //3
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}