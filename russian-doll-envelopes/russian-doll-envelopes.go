import "sort"

func binarySearch(nums []int, target int) int {
    left, right := 0, len(nums) - 1
    for left <= right {
        mid := left + (right - left)/2
        if nums[mid] < target {
            left = mid + 1
        }else{
            right = mid - 1
        }
    }
    return left
}

func LIS(nums []int) int{
    sub := []int{}
    sub = append(sub, nums[0])

    for i := 1; i < len(nums); i++ {
        if nums[i] > sub[len(sub) - 1] {
            sub = append(sub, nums[i])
        }else{
            sub[binarySearch(sub, nums[i])] = nums[i]
        }
    }
    return len(sub)
}
func maxEnvelopes(envelopes [][]int) int {
    sort.SliceStable(envelopes, func(i, j int) bool {
        if envelopes[i][0] == envelopes[j][0]{
            return envelopes[j][1] < envelopes[i][1]
        }else{
            return envelopes[i][0] < envelopes[j][0]
        }
    })

    dp := []int{}
    for i := 0; i < len(envelopes); i++ {
        dp = append(dp, envelopes[i][1])
    }    
    return LIS(dp)
}