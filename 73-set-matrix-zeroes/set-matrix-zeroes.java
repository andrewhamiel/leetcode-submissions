class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;

        //mark first row/col if zero found
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0) isCol = true;
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //zero out rows/columns that have been marked
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        //check first row
        if(matrix[0][0] == 0){
            for(int j = 1; j < matrix[0].length; j++) matrix[0][j] = 0;
        }
        //check first column
        if(isCol){
            for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}