class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum+= nums[right];
            if(map.containsKey(sum - k)) result+= map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}