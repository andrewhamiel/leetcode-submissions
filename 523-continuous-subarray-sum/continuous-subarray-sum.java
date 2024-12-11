class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //first index of sum % k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int count = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(!map.containsKey(sum % k)) map.put(sum % k, i + 1);
            else if(map.get(sum % k) < i) return true;
        }
        return false;
    }
}