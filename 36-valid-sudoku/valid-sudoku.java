class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use a binary number to record previous occurrence
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // Check if the position is filled with number
                if (board[row][col] == '.') continue;
                
                int val = board[row][col] - '0';
                int pos = 1 << (val - 1);

                // Check the row
                if ((rows[row] & pos) > 0) return false;                
                rows[row] |= pos;

                // Check the column
                if ((cols[col] & pos) > 0) return false;
                cols[col] |= pos;

                // Check the box
                int ind = (row / 3) * 3 + col / 3;
                if ((boxes[ind] & pos) > 0) return false;
                boxes[ind] |= pos;
            }
        }
        return true;
    }
}