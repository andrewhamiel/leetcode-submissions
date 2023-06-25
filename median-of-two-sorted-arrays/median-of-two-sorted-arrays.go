import "math"
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    if len(nums1) > len(nums2){
        return findMedianSortedArrays(nums2, nums1)
    }
    left, right := 0, len(nums1)
    for left <= right {
        partitionA := left + (right - left)/2
        partitionB := (len(nums1) + len(nums2) + 1)/2 - partitionA

        maxLeftA, maxLeftB := math.MinInt32, math.MinInt32
        minRightA, minRightB := math.MaxInt32, math.MaxInt32
        if partitionA > 0 {
            maxLeftA = nums1[partitionA - 1]
        }
        if partitionA < len(nums1){
            minRightA = nums1[partitionA]
        }
        if partitionB > 0 {
            maxLeftB = nums2[partitionB - 1]
        }
        if partitionB < len(nums2){
            minRightB = nums2[partitionB]
        }

        if maxLeftA <= minRightB && maxLeftB <= minRightA {
            if (len(nums1) + len(nums2)) % 2 == 0 {
                return float64((max(maxLeftA, maxLeftB) + min(minRightA, minRightB)))/2.0
            }else{
                return float64(max(maxLeftA, maxLeftB))
            }
        }else if maxLeftA > minRightB {
            right = partitionA - 1
        }else{
            left = partitionA + 1
        }
    }
    return 0.0
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a <= b {
        return a
    }
    return b
}