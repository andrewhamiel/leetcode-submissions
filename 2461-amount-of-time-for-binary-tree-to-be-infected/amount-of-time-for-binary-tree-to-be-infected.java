/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            map.putIfAbsent(curr.val, new ArrayList<>());
            if(curr.left != null){
                map.get(curr.val).add(curr.left.val);
                map.putIfAbsent(curr.left.val, new ArrayList<>());
                map.get(curr.left.val).add(curr.val);
                q.add(curr.left);
            }
            if(curr.right != null){
                map.get(curr.val).add(curr.right.val);
                map.putIfAbsent(curr.right.val, new ArrayList<>());
                map.get(curr.right.val).add(curr.val);
                q.add(curr.right);
            }
        }

        Queue<Integer> infected  = new LinkedList<>();
        infected.add(start);
        int time = -1;
        
        while(!infected.isEmpty()){
            int size = infected.size();            
            while(size-- > 0){
                int curr = infected.poll();
                List<Integer> nextNodes = map.remove(curr);
                for(int nextNode : nextNodes) if(map.containsKey(nextNode)) infected.add(nextNode);
            }
            time++;
        }
        return time;
    }
}