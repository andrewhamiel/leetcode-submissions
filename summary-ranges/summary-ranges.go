func summaryRanges(nums []int) []string {
	result := []string{}
	r := ""

	for i := 0; i < len(nums); {
		r = r + strconv.Itoa(nums[i])
		j := i + 1
		for ; j < len(nums) && nums[j]-nums[j-1] == 1; j++ {
		}
		if j-1 > i {
			r = r + "->" + strconv.Itoa(nums[j-1])
		}
		result = append(result, r)
		r = ""
		i = j
	}
	return result
}