func findMin(nums []int) int {
    if len(nums) == 1 || nums[0] < nums[len(nums) - 1]{
        return nums[0]
    }
    //find min index
    left, right := 0, len(nums) - 1
    for left < right {
        mid := left + (right - left)/2
        if nums[mid] < nums[right]{
          right = mid
        }else if nums[mid] > nums[right]{
          left = mid + 1
        }else{
          right--
        }
    }
    return nums[left]
    
}