class Solution {
    private int diameter = 0;

    public int diameter(Node root) {
        height(root);
        return diameter;
    }

    /**
     * return the height of the node
     */
    private int height(Node node) {
        if (node.children.size() == 0) return 0;

        // select the top two largest heights
        int maxHeight1 = 0, maxHeight2 = 0;
        for (Node child : node.children) {
            int parentHeight = height(child) + 1;
            //1. Determine if parentHeight top 2
            if (parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            } else if (parentHeight > maxHeight2) maxHeight2 = parentHeight;

            // calculate the distance between the two farthest leaves nodes.
            int distance = maxHeight1 + maxHeight2;
            diameter = Math.max(diameter, distance);
        }

        return maxHeight1;
    }

    
}