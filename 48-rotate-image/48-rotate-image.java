class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //reflect
        for(int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix.length - 1;
            while(left < right){
                int tmp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = tmp;
            }
        }
    }
}