/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int diameter = 0;

    public int diameter(Node root) {
        depth(root, 0);
        return diameter;
    }

    private int depth(Node root, int currDepth){
        if(root == null) return currDepth;

        int maxDepth1 = currDepth, maxDepth2 = 0;
        for(Node child : root.children){
            int newDepth = depth(child, currDepth + 1);

            //see if new depth in top 2
            if(newDepth > maxDepth1){
                maxDepth2 = maxDepth1;
                maxDepth1 = newDepth;
            }else if(newDepth > maxDepth2) maxDepth2 = newDepth;

            //calculate longest path
            int distance = maxDepth1 + maxDepth2 - 2 * currDepth;
            diameter = Math.max(diameter, distance);
        }
        return maxDepth1;
    }
}