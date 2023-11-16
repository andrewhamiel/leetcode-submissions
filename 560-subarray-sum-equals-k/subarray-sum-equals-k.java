class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixes = new HashMap<>();
        prefixes.put(0, 1);
        
        int result = 0, sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum+= nums[right];
            if(prefixes.containsKey(sum - k)) result+= prefixes.get(sum - k);
            prefixes.put(sum, prefixes.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}