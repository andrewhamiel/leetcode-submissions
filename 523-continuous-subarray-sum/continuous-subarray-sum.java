class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            if(map.containsKey(sum % k) && map.get(sum % k) < i) return true;
            map.putIfAbsent(sum % k, i + 1);
        }
        return false;
    }
}