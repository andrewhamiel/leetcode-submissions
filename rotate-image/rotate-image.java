class Solution {
    public void rotate(int[][] matrix) {
        //2 steps
        //1. transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        //2. reflect
        for(int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix[0].length - 1;
            while(left < right){
                int tmp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = tmp;
            }
        }
    }
}