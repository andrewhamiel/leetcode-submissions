class NumMatrix {
    int[][] mat;

    public NumMatrix(int[][] matrix) {
        //cumulative region sum
        mat = new int[matrix.length + 1][matrix[0].length + 1];
        for(int row = 0; row < matrix.length; row++){
            int rowSum = 0;
            for(int col = 0; col < matrix[0].length; col++){
                rowSum+= matrix[row][col];
                int colSum = mat[row][col + 1];
                mat[row + 1][col + 1] = rowSum + colSum;
            }
        }
    }
    
    //principle of inclusion-exclusion
    //sum(oa) covered twice in sum(ob) and sum(oc)
    //sum(abcd) = sum(od) - sum(oc) - sum(ob) + sum(oa)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mat[row2 + 1][col2 + 1] - mat[row1][col2 + 1] - mat[row2 + 1][col1] + mat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */