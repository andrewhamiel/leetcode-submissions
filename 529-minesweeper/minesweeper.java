class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            //Mine
            if(board[row][col] == 'M') board[row][col] = 'X';
            else{
                //Get mines
                int mines = getMines(row, col, board);
                if(mines > 0) board[row][col] = (char)(mines + '0');
                else{
                    board[row][col] = 'B';
                    for(int[] dir : dirs){
                        int i = row + dir[0], j = col + dir[1];
                        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'E') {
                            q.add(new int[]{i, j});
                            board[i][j] = 'B';
                        }
                    }
                }
                
            }
        }
        return board;
    }

    private int getMines(int row, int col, char[][] board){
        int mines = 0;
        for(int[] dir : dirs){
            int i = row + dir[0], j = col + dir[1];
            if(i >= 0 && i < board.length && j >= 0 && j < board[0].length 
            && (board[i][j] == 'M' || board[i][j] == 'X')) mines++;
        }
        return mines;
    }
}