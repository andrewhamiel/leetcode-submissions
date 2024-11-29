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
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findNeighbors(root, null);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while(!q.isEmpty() && k >= 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(k == 0) result.add(curr.val);
                for(TreeNode neighbor : map.getOrDefault(curr, new ArrayList<>())) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            k--;
        }
        return result;
    }

    private void findNeighbors(TreeNode child, TreeNode parent) {
        if(parent != null) {
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            map.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
        }
        if(child.left != null) findNeighbors(child.left, child);
        if(child.right != null) findNeighbors(child.right, child);
    }
}