class Solution {
    public void rotate(int[][] matrix) {
        //rotation on 2D plane: (x, y) -> (y, -x)
        //2 steps

        //1. Transpose: flip across diagonal from top left -> bottom right
        for(int row = 0; row < matrix.length; row++) {
            //Avoid duplicate swaps
            for(int col = row; col < matrix[0].length; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        //2. Reflect: flip horizontally from left -> right
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