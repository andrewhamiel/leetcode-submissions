class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        q.add(click);

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            if(board[row][col] == 'M') board[row][col] = 'X';
            else {
                int mines = getMines(row, col, board);
                if(mines > 0) board[row][col] = (char)(mines + '0');
                else {
                    board[row][col] = 'B';
                    for(int[] dir : dirs) {
                        int newRow = row + dir[0], newCol = col + dir[1];
                        if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                            && board[newRow][newCol] == 'E') {
                                board[newRow][newCol] = 'B';
                                q.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        return board;
    }

    private int getMines(int row, int col, char[][] board) {
        int mines = 0;
        for(int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length 
                && (board[newRow][newCol] == 'X' || board[newRow][newCol] == 'M')) mines++;
        }
        return mines;
    }
}