class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }    

        int[] freqs = new int[map.size()];
        int ind = 0;
        for(int num : map.keySet()) freqs[ind++] = num;

        quickselect(0, freqs.length - 1, freqs, k -1);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) result[i] = freqs[i];
        return result;
    }

    private void quickselect(int left, int right, int[] nums, int k) {
        if(left >= right) return;

        int pivotInd = new Random().nextInt(right - left) + left;
        pivotInd = partition(left, right, nums, pivotInd);

        if(pivotInd == k) return;
        else if(pivotInd < k) quickselect(pivotInd + 1, right, nums, k);
        else quickselect(left, pivotInd - 1, nums, k);
    }

    private int partition(int left, int right, int[] nums, int pivotInd) {
        int pivotFreq = map.get(nums[pivotInd]);
        swap(pivotInd, right, nums);
        int swapInd = left;
        for(int i = left; i <= right; i++) {
            if(map.get(nums[i]) > pivotFreq) swap(swapInd++, i, nums);
        }
        swap(swapInd, right, nums);
        return swapInd;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}