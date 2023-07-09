func lengthOfLongestSubstringKDistinct(s string, k int) int {
    freq := map[byte]int{}
    left,  maxSize := 0, 0
    for right := 0; right < len(s); right++ {
        if _, ok := freq[s[right]]; !ok {
            freq[s[right]] = 1
        }else{
            freq[s[right]]++
        }
        for len(freq) > k {
            if freq[s[left]] == 1 {
                delete(freq, s[left])
            }else{
                freq[s[left]]--
            }
            left++
        }
        maxSize = max(maxSize, right - left + 1)
    }
    return maxSize
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}