class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> nodes = new HashSet<>(); 
        for (int val : to_delete) {
            nodes.add(val);
        }
        List<TreeNode> ans = new ArrayList<>();
        if (!delete(root, ans, nodes)) ans.add(root);
        
        return ans; 
    }
    
    // Returns true if the node was deleted
    public boolean delete(TreeNode node, List<TreeNode> list, Set<Integer> nodes) {
        if (node == null) return true;
        
        if (nodes.contains(node.val)) {
            // Node to be deleted
            if (!delete(node.left, list, nodes)) list.add(node.left);           
            if (!delete(node.right, list, nodes)) list.add(node.right);
            
            return true;
        } else {
            if (delete(node.left, list, nodes)) node.left = null;           
            if (delete(node.right, list, nodes)) node.right = null;

            return false;
        }
    }
}