class NumMatrix {
    
    int[][] matrix;
    public NumMatrix(int[][] mat) {
        if(mat.length==0 || mat[0].length==0)return;
        matrix = new int[mat.length+1][mat[0].length+1];
         for(int r=0;r<mat.length;++r){
            int rowSum = 0;
            for(int c=0;c<mat[0].length;++c){
                rowSum+= mat[r][c];
                matrix[r+1][c+1]=matrix[r][c+1]+rowSum;
            }
         }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2 + 1][col2 + 1] - matrix[row1][col2 + 1] - matrix[row2 + 1][col1] + matrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */