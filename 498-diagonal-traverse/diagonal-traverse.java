class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] result = new int[rows * cols];
        int row = 0, col = 0, k = 0, direction = 1;
        
        while(row < rows && col < cols){
            result[k++] = mat[row][col];
            //Diagonally traverse
            int newRow = row, newCol = col;
            if(direction == 1){
                newRow--;
                newCol++;
            }else{
                newCol--;
                newRow++;
            }

            //Correct if at bounds
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols){
                if(direction == 1){
                    row+= (col == cols - 1 ? 1 : 0);
                    col+= (col < cols - 1 ? 1 : 0);
                }else{
                    col+= (row == rows - 1 ? 1 : 0);
                    row+= (row < rows - 1 ? 1 : 0);
                }
                direction*= -1;
            }else{
                row = newRow;
                col = newCol;
            }
        }
        return result;
    }
}