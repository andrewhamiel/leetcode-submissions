class Solution {
    private int[] unique;
    Map<Integer, Integer> count = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        unique = new int[count.size()];
        int ind = 0;
        for(int num : count.keySet()) unique[ind++] = num;

        quickselect(0, unique.length - 1, unique.length - k);
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++) result[i] = unique[unique.length - k + i];
        return result;
    }

    private void quickselect(int left, int right, int k){
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, pivotIndex);

        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, k);
        else quickselect(left, pivotIndex - 1, k);
    }

    private int partition(int left, int right, int pivotIndex){
        int pivotValue = count.get(unique[pivotIndex]);
        swap(pivotIndex, right);
        int swapIndex = left;
        for(int i = left; i <= right; i++){
            if(count.get(unique[i]) < pivotValue) swap(i, swapIndex++);
        }
        swap(swapIndex, right);
        return swapIndex;
    }

    private void swap(int i, int j){
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }
}