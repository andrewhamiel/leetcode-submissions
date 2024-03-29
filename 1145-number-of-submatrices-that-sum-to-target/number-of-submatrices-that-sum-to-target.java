class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //1. Compute prefix sum
        int[][] prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for(int row = 1; row < prefix.length; row++){
            for(int col = 1; col < prefix[0].length; col++){
                prefix[row][col] = prefix[row - 1][col] + prefix[row][col - 1] - prefix[row - 1][col - 1] + matrix[row - 1][col - 1];
            }
        }

        //2. Solve as 1D problem with 2-row comparison
        int count = 0;
        for(int row1 = 1; row1 < prefix.length; row1++){
            for(int row2 = row1; row2 < prefix.length; row2++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for(int col = 1; col < prefix[0].length; col++){
                    int currSum = prefix[row2][col] - prefix[row1 - 1][col];
                    count+= map.getOrDefault(currSum - target, 0);
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                }
            }
        }
        return count;
    }
}