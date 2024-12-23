class Solution {
    private int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {4, 2}};
    private Map<String, Integer> visited = new HashMap<>();

    public int slidingPuzzle(int[][] board) {
        StringBuilder startState = new StringBuilder();
        for(int row = 0; row < 2; row++) {
            for(int col = 0; col < 3; col++) {
                startState.append(board[row][col]);
            }
        }

        dfs(startState.toString(), startState.indexOf("0"), 0);

        return visited.getOrDefault("123450", -1);
    }

    private void dfs(String currState, int zeroInd, int moves) {
        if(visited.containsKey(currState) && visited.get(currState) <= moves) return;

        visited.put(currState, moves);

        for(int nextInd : dirs[zeroInd]) {
            char[] arr = currState.toCharArray();
            swap(zeroInd, nextInd, arr);
            dfs(new String(arr), nextInd, moves + 1);
        }
    }

    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}