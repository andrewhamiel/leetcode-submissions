func generate(numRows int) [][]int {
    ans := [][]int{}
    
    ans = append(ans, []int{1})
    if numRows == 1 {
        return ans
    }
    ans = append(ans, []int{1, 1})
    if numRows == 2 {
        return ans
    }

    first := []int{1, 1}
    for i := 2; i < numRows; i++ {
        tmp := make([]int, len(first) + 1)
        tmp[0] = 1
        for i := 1; i < len(first); i++ {
            tmp[i] = first[i] + first[i-1]
        }
        tmp[len(tmp) - 1] = 1
        forArray := make([]int, len(tmp))
        copy(forArray, tmp)
        ans = append(ans, forArray)
        first = tmp
    }
    return ans
}