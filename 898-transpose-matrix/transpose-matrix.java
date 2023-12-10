class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for(int r = 0; r < result.length; r++){
            for(int c = 0; c < result[0].length; c++)
                result[r][c] = matrix[c][r];
        }
        return result;
    }
}