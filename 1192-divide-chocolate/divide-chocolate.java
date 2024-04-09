class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int min = sweetness[0], sum = 0;
        for(int piece : sweetness){
            min = Math.min(min, piece);
            sum+= piece;
        }
        int left = min, right = sum;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(sweetness, mid, k))right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean isFeasible(int[] nums, int sum, int k){
        int currSum = 0, cuts = 0;
        for(int num : nums){
            currSum+= num;
            if(currSum > sum){
                cuts++;
                currSum = 0;
            }
        }
        return cuts < k + 1;
    }
}