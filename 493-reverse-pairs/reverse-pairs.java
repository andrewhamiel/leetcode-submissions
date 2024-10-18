class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    private int mergeSort(int low, int high, int[] nums) {
        if(low >= high) return 0;

        int mid = low + (high - low)/2;
        int pairs = mergeSort(low, mid, nums) + mergeSort(mid + 1, high, nums) + countPairs(low, high, nums);

        merge(low, high, nums);
        return pairs;
    }

    private int countPairs(int low, int high, int[] nums) {
        int mid = low + (high - low)/2, count = 0, j = mid + 1;
        for(int i = low; i <= mid; i++) {
            while(j <= high && nums[i] > 2 *(long) nums[j]) j++;
            count+= j - mid - 1;
        }
        return count;
    }

    private void merge(int low, int high, int[] nums) {
        List<Integer> tmp = new ArrayList<>();

        int mid = low + (high - low)/2, left = low, right = mid + 1;
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) tmp.add(nums[left++]);
            else tmp.add(nums[right++]);
        }
        
        while(left <= mid) tmp.add(nums[left++]);
        while(right <= high) tmp.add(nums[right++]);

        for(int i = low; i <= high; i++) nums[i] = tmp.get(i - low);
    }
}