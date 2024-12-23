class Solution {
    private int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    private String target = "123450";

    public int slidingPuzzle(int[][] board) {
        StringBuilder startState = new StringBuilder();
        int startInd = 0;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                startState.append(board[row][col]);
                if(board[row][col] == 0) startInd = 3 * row + col;
            }
        }    

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(startState.toString(), startInd));
        Set<String> visited = new HashSet<>();
        visited.add(startState.toString());

        int moves = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair<String, Integer> p = q.poll();
                String currState = p.getKey();
                int zeroInd = p.getValue();

                if(currState.equals(target)) return moves;

                for(int nextInd : dirs[zeroInd]) {
                    char[] arr = currState.toCharArray();
                    swap(zeroInd, nextInd, arr);
                    String nextState = new String(arr);
                    if(!visited.contains(nextState)) {
                        visited.add(nextState);
                        q.add(new Pair<>(nextState, nextInd));
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}