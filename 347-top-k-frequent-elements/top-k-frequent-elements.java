class Solution {
    Map<Integer, Integer> count = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {       
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        
        int[] unique = new int[count.size()];
        int ind = 0;
        for(int num : count.keySet()) unique[ind++] = num;

        quickselect(0, unique.length - 1, unique, k);
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) result[i] = unique[i];
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

    private int partition(int left, int right, int[] nums, int pivotIndex){
        int pivotFreq = count.get(nums[pivotIndex]);
        swap(pivotIndex, right, nums);
        int swapInd = left;

        for(int i = left; i <= right; i++){
            if(count.get(nums[i]) > pivotFreq) swap(i, swapInd++, nums);
        }
        swap(swapInd, right, nums);
        return swapInd;
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}