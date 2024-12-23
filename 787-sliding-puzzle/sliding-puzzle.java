class Solution {
    private int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    private Map<String, Integer> visited = new HashMap<>();

    public int slidingPuzzle(int[][] board) {
        StringBuilder currState = new StringBuilder();
        int zeroInd = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                currState.append(board[row][col]);
                if(board[row][col] == 0) zeroInd = 3 * row + col;
            }
        }    

        dfs(currState.toString(), board, zeroInd, 0);

        return visited.getOrDefault("123450", -1);
    }

    private void dfs(String currState, int[][] board, int zeroInd, int moves) {
        if(visited.containsKey(currState) && visited.get(currState) <= moves) return;

        visited.put(currState, moves);

        for(int nextInd : dirs[zeroInd]) {
            char[] arr = currState.toCharArray();
            swap(zeroInd, nextInd, arr);
            dfs(new String(arr), board, nextInd, moves + 1);
        }
    }

    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}