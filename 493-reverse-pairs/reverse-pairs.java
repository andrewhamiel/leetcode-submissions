class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    private int mergeSort(int start, int end, int[] nums) {
        if(start >= end) return 0;

        int mid = start + (end - start)/2;
        int pairs = mergeSort(start, mid, nums) + mergeSort(mid + 1, end, nums) + countPairs(start, end, nums);

        merge(start, end, nums);

        return pairs;
    }

    private int countPairs(int start, int end, int[] nums) {
        int mid = start + (end - start)/2, count = 0, right = mid + 1;
        for(int left = start; left <= mid; left++) {
            while(right <= end && nums[left] > 2 * (long) nums[right]) right++;
            //Right is now first index where condition does not hold true
            count+= right - mid - 1;
        }
        return count;
    }

    private void merge(int start, int end, int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        int mid = start + (end - start)/2, left = start, right = mid + 1;
        while(left <= mid && right <= end) {
            if(nums[left] <= nums[right]) tmp.add(nums[left++]);
            else tmp.add(nums[right++]);
        }

        while(left <= mid) tmp.add(nums[left++]);
        while(right <= end) tmp.add(nums[right++]);

        for(int i = start; i <= end; i++) nums[i] = tmp.get(i - start);
    }
}