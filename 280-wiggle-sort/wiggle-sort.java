class Solution {
    public void wiggleSort(int[] nums) {
        //count
        int[] freq = new int [10001];
        for(int num : nums) freq[num]++;

        int left = 0, right = freq.length - 1;
        for(int resultInd = 0; resultInd < nums.length; resultInd++){
            if(resultInd % 2 == 0){
                while(freq[left] == 0) left++;
                nums[resultInd] = left;
                freq[left]--;
            }else{
                while(freq[right] == 0) right--;
                nums[resultInd] = right;
                freq[right]--;
            }
        }
    }
}