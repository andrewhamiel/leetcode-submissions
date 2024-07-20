class Solution {
    
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] arr = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                arr[i][j] = Math.min(rowSum[i], colSum[j]);
                //Also need to decrement existing rowSum and colSum
                rowSum[i] -= arr[i][j];
                colSum[j] -= arr[i][j];
            }
        }
        return arr;
    }
    //two arrays
    //1. rowSum: rowSum[i] == sum of the elements in the ith row
    //2. colSum: rowSum[j] == sum of the elements in the jth row
    //so need to find a matrix that satisfies these reqs
    
    //Constraints: rowSum at least 1 in length, colSum can be 0 so have to check that
    //Cells can be 0
    //Ideas: Diagonal cells are the only ones filled, rest are 0? Let's try
    // Not equal, but can take the minimum and leave the remainder to be added elsewhere later
}