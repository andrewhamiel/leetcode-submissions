class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(i - k >= 0) {
                map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);
                if(map.get(nums[i - k]) == 0) map.remove(nums[i - k]);
            }
            if(i - k + 1 >= 0) result[i - k + 1] = map.size();
        }
        return result;
    }
}