class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = board.length;
        for(int i = 2; i <= n * n; i++){
            int[] pos = getPos(i, n);
            int x = pos[0], y = pos[1];
            if(board[x][y] != -1) map.put(i, board[x][y]);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(1);

        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int pos = q.poll();
                if(pos >= n * n) return moves;
                for(int i = pos + 1; i <= pos + 6; i++){
                    int nextPos = map.containsKey(i) ? map.get(i) : i;
                    
                    if(!seen.contains(nextPos)) {
                        q.add(nextPos);
                        seen.add(nextPos);
                    }
                }
                
            }
            moves++;
        }
        return -1;
    }

    private int[] getPos(int ind, int n){
        ind--; //0-indexed
        int row = n - 1 - (ind/n); 
        int col = ind % n;
        boolean isEven = (ind/n) % 2 == 0;
        return isEven ? new int[]{row, col} : new int[]{row, n - 1 - col};
    }
}