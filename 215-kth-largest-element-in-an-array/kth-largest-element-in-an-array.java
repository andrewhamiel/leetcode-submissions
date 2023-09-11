class Solution {
    public int findKthLargest(int[] nums, int k) {
        //counting sort
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] count = new int[max - min + 1];
        for(int num : nums){
            count[num - min]++;
        }
        int remain = k;
        for(int i = count.length - 1; i >= 0; i--){
            remain-= count[i];
            if(remain <= 0){
                return i + min;
            }
        }
        return -1;
    }
}