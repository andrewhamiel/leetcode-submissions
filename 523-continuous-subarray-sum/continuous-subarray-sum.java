class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            int rem = (int) sum % k;
            if(!map.containsKey(rem)) map.put(rem, i + 1);
            else if(map.get(rem) < i) return true;
        }
        return false;
    }
}