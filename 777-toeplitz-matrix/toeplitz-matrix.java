class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //first col
        for(int j = 0; j < matrix[0].length - 1; j++) if(!isToeplitz(0, j, matrix)) return false;
        //first row
        for(int i = 0; i < matrix.length - 1; i++) if(!isToeplitz(i, 0, matrix)) return false;
        return true;
    }

    private boolean isToeplitz(int i, int j, int[][] matrix){
        int value = matrix[i][j];
        while(i < matrix.length && j < matrix[0].length){
            if(matrix[i++][j++] != value) return false;
        }
        return true;
    }
}