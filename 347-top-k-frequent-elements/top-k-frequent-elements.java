class Solution {
    Map<Integer, Integer> count = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        int[] freqs = new int[count.size()];
        int ind = 0;
        for(int num : count.keySet()) freqs[ind++] = num;

        quickselect(0, freqs.length - 1, freqs, k - 1);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) result[i] = freqs[i];
        return result;
    }

    private void quickselect(int left, int right, int[] nums, int k){
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, nums, pivotIndex);

        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, nums, k);
        else quickselect(left, pivotIndex - 1, nums, k); 
    }

    private int partition(int left, int right, int[] nums, int pivotIndex) {
        int pivotValue = count.get(nums[pivotIndex]);
        swap(pivotIndex, right, nums);
        int swapIndex = left;
        
        for(int i = left; i <= right; i++) {
            if(count.get(nums[i]) > pivotValue) swap(swapIndex++, i, nums);
        }
        swap(swapIndex, right, nums);
        return swapIndex;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}