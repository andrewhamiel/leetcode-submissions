func findClosestElements(arr []int, k int, x int) []int {
    left, right := 0, len(arr) - k
    for left < right {
        mid := left + (right - left)/2
        if x - arr[mid] > arr[mid + k] - x {
            left = mid + 1
        }else {
            right = mid
        }
    }
    ans := arr[left:left+k]
    return ans
}