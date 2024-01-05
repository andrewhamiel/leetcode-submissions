class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > sub.get(sub.size() - 1)) sub.add(nums[i]);
            else{
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }

    private int binarySearch(List<Integer> sub, int num){
        int left = 0, right = sub.size() - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(sub.get(mid) == num) return mid;
            else if(sub.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}