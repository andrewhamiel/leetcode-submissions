class Solution {
    private int diameter = 0;

    public int diameter(Node root) {
        this.diameter = 0;
        maxDepth(root, 0);
        return diameter;
    }

    /**
     * return the maximum depth of leaves nodes descending from the given node
     */
    private int maxDepth(Node node, int currDepth) {
        if (node.children.size() == 0) return currDepth;

        // select the top two largest depths
        int maxDepth1 = currDepth, maxDepth2 = 0;
        for (Node child : node.children) {
            int depth = maxDepth(child, currDepth + 1);
            //determine if top 2 depths
            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }
            // calculate the distance between the two farthest leaves nodes.
            int distance = maxDepth1 + maxDepth2 - 2 * currDepth;
            this.diameter = Math.max(this.diameter, distance);
        }

        return maxDepth1;
    }

    
}