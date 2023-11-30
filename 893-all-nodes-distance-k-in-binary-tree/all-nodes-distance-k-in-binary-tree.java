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
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target.val, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int[] entry = q.poll();
            int curr = entry[0], distance = entry[1];
            visited.add(curr);
            if(distance == k){
                result.add(curr);
                continue;
            }
            for(int neighbor : graph.getOrDefault(curr, new ArrayList<>())){
                if(!visited.contains(neighbor)) q.add(new int[]{neighbor, distance + 1});
            }
        }
        return result;
    }

    private void buildGraph(TreeNode root, TreeNode parent){
        if(root != null && parent != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }
        if(root.left != null) buildGraph(root.left, root);
        if(root.right != null) buildGraph(root.right, root);
    }
}