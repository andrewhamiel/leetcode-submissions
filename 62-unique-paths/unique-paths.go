func uniquePaths(m int, n int) int {
    //ones for first row/col
    grid := make([][]int, m)
    for i := range(grid) {
        grid[i] = make([]int, n)
    }
    for i := 0; i < n; i++ {
        grid[0][i] = 1
    }

    for i := 0; i < m; i++ {
        grid[i][0] = 1
    }

    //DP from top left down to bottom right
    for i := 1; i < len(grid); i++ {
        for j := 1; j < len(grid[0]); j++ {
            grid[i][j] = grid[i-1][j] + grid[i][j-1]
        }
    }
    return grid[m-1][n-1]
}