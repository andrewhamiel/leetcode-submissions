class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //check starting at each row
        for(int row = 0; row < matrix.length; row++) if(!isToeplitz(row, 0, matrix)) return false;
        //check starting in first row at each column after zero
        for(int col = 1; col < matrix[0].length; col++) if(!isToeplitz(0, col, matrix)) return false;
        return true;
    }

    private boolean isToeplitz(int row, int col, int[][] matrix){
        int originalValue = matrix[row][col];
        while(row < matrix.length && col < matrix[0].length){
            if(matrix[row++][col++] != originalValue) return false;
        }
        return true;
    }
}