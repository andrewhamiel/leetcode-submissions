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
        height(root);
        return diameter;
    }

    private int height(Node root){
        if(root == null) return 0;

        int maxHeight1 = 0, maxHeight2 = 0;
        for(Node child : root.children){
            int parentHeight = height(child) + 1;

            //determine if parent height top 2
            if(parentHeight > maxHeight1){
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            }else if(parentHeight > maxHeight2) maxHeight2 = parentHeight;

            //determine longest path
            int distance = maxHeight1 + maxHeight2;
            diameter = Math.max(diameter, distance);
        }
        return maxHeight1;
    }
}