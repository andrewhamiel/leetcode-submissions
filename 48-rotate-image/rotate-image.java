class Solution {
    public void rotate(int[][] matrix) {
        //2 steps
        //1. Transpose = flip diagonals
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){ //Tricky start for j here!!
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //2. Reflect = flip columns in a row
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