class Solution {
    class DSU {
        int[] parent;
        int[] size;

        public DSU(int size) {
            this.size = new int[size];
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                this.size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // Union By Size

        public boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) {
                return false;
            } else if (size[xr] < size[yr]) {
                parent[xr] = yr;
                size[yr] += size[xr];
            }
           else {
                parent[yr] = xr;
                size[xr] += size[yr];
            }
            return true;
        }
    }

    private int[][] drc = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                
                for (int[] d : drc){
                    int r = d[0] + i, c = d[1] + j;
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                        dsu.union(i*n + j, r*n + c);
                    }
                }
            }
        }
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    maxSize = Math.max(maxSize, dsu.size[dsu.find(i*n + j)]);
                    continue;
                }
                int[][] drc = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                HashSet<Integer> visited = new HashSet<>();
                int currSize = 0;
                for (int[] d : drc){
                    int r = d[0] + i, c = d[1] + j;
                    boolean rbound = 0 <= r && r < n;
                    boolean cbound = 0 <= c && c < n;

                    if (rbound && cbound && grid[r][c] == 1 && !visited.contains(dsu.find(r*n + c))){
                        visited.add(dsu.find(r*n + c));
                        currSize += dsu.size[dsu.parent[r*n + c]];
                    }
                }
                maxSize = Math.max(maxSize, currSize + 1);
            }
        }

        return maxSize;
    }    
}