class Solution {
    public void rotate(int[][] matrix) {
        //2 Steps
        //1. Transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //2. Reflect
        for(int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix[i].length - 1;
            while(left < right){
                int tmp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = tmp;
            }
        }
    }
}