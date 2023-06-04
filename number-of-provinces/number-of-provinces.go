func dfs(curr int, visited []bool, isConnected [][]int) {
    visited[curr] = true
    for next := 0; next < len(isConnected); next++ {
        if isConnected[curr][next] == 0 {continue} 
        if !visited[next] {
            dfs(next, visited, isConnected)
        }
    } 
}

func findCircleNum(isConnected [][]int) int {
    var count int = 0
    visited := make([]bool, len(isConnected))
    for i := 0; i < len(isConnected); i++ {
        if !visited[i] {
            count++
            dfs(i, visited, isConnected)
        }
    }
    return count
}