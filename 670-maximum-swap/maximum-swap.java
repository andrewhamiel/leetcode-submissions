class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] rightmost = new int[10];
        for(int i = 0; i < nums.length; i++) rightmost[nums[i] - '0'] = i;

        for(int i = 0; i < nums.length; i++){
            for(char c = '9'; c > nums[i]; c--){
                if(rightmost[c - '0'] > i){
                    swap(i, rightmost[c - '0'], nums);
                    return Integer.parseInt(new String(nums));
                }
            }
        }
        return Integer.parseInt(new String(nums));
    }

    private void swap(int i, int j, char[] nums){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}