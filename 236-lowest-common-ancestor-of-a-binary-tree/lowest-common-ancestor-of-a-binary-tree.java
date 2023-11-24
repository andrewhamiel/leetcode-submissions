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

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.removeFirst();

            if(node.left != null){
                parent.put(node.left, node);
                stack.addFirst(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                stack.addFirst(node.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}