func minPathSum(grid [][]int) int {
    for j := 1; j < len(grid[0]); j++{
        grid[0][j]+= grid[0][j-1]
    }
    for i := 1; i < len(grid); i++ {
        grid[i][0] += grid[i-1][0]
    }
    for i := 1; i < len(grid); i++ {
        for j := 1; j < len(grid[0]); j++ {
            grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        }
    }
    return grid[len(grid) - 1][len(grid[0])-1]
}

func min(a, b int) int {
    if a <= b {
        return a
    }
    return b
}