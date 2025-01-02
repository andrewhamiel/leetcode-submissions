class Solution {
    public void rotate(int[][] matrix) {
        //2 Steps

        //1. Transpose
        for(int row = 0; row < matrix.length; row++) {
            for(int col = row; col < matrix[0].length; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
        //2. Reflect
        for(int row = 0; row < matrix.length; row++) {
            int left = 0, right = matrix[row].length - 1;
            while(left < right) {
                int tmp = matrix[row][left];
                matrix[row][left++] = matrix[row][right];
                matrix[row][right--] = tmp;
            }
        }
    }
}