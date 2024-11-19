class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < nums.size(); i++) {
            if(i - curr == k) {
                map.put(curr, i);
                curr++;
            }
            if(nums.get(i) <= nums.get(i - 1)) curr = i;
        }

        //check last element 
        if((k == 1 || nums.get(nums.size() - 1) > nums.get(nums.size() - 2)) && nums.size() - curr == k) map.put(curr, nums.size() - 1);

        for(int key : map.keySet()) {
            if(map.containsKey(map.get(key))) return true;
        }
        return false;
    }
}