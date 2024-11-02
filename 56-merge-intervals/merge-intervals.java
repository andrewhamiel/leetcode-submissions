class Solution {
    class Node {
        int low, high;
        Node left, right;

        public Node(int[] interval) {
            low = interval[0];
            high = interval[1];
        }
    }

    public int[][] merge(int[][] intervals) {
        Node root = new Node(intervals[0]);
        //1. Add 
        for(int i = 1; i < intervals.length; i++) add(root, intervals[i]);
        //2. Merge 
        List<int[]> merged = merge(root);
        //3. Build result
        int[][] result = new int[merged.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = merged.get(i);
        return result;
    }

    private List<int[]> merge(Node root) {
        if(root == null) return new ArrayList<>();

        List<int[]> result = new ArrayList<>();
        List<int[]> left = merge(root.left), right = merge(root.right);

        boolean isInserted = false;
        for(int[] interval : left) {
            if(interval[1] >= root.low) {
                interval[0] = Math.min(interval[0], root.low);
                interval[1] = Math.max(interval[1], root.high);
                root = new Node(interval);
                isInserted = true;
            }
            result.add(interval);
        } 

        if(!isInserted) result.add(new int[]{root.low, root.high});

        for(int[] interval : right) {
            if(interval[0] <= root.high) {
                interval[0] = Math.min(interval[0], root.low);
                interval[1] = Math.max(interval[1], root.high);
                root.high = interval[1];
                result.remove(result.size() - 1);
            }
            result.add(interval);
        }
        return result;
    }

    private Node add(Node root, int[] interval) {
        if(root == null) return new Node(interval);

        if(interval[0] < root.low) root.left = add(root.left, interval);
        else root.right = add(root.right, interval);
        return root;
    }
}