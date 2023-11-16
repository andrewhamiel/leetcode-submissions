class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null) return new int[0];
        int N = mat.length, M = mat[0].length, k = 0;
        int[] result = new int[N * M];
        int row = 0, col = 0, direction = 1;
        while(row < N && col < M){
            result[k++] = mat[row][col];
            int newRow = row, newCol = col;
            if(direction == 1){
                newRow--;
                newCol++;
            }else{
                newRow++;
                newCol--;
            }

            if(newRow < 0 || newRow == N || newCol < 0 || newCol == M){
                if(direction == 1){
                    row+= (col == M - 1 ? 1 : 0);
                    col+= (col < M - 1 ? 1 : 0);
                }else{
                    col+= (row == N - 1 ? 1 : 0);
                    row+= (row < N - 1 ? 1 : 0);
                }
                direction = 1 - direction;
            }else{
                row = newRow;
                col = newCol;
            }
        }
        return result;
    }
}