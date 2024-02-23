class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minDistance = arrays.get(0).get(0), maxDistance = arrays.get(0).get(arrays.get(0).size() - 1), ans = 0;
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> arr = arrays.get(i);
            ans = Math.max(ans, Math.max(Math.abs(maxDistance - arr.get(0)), Math.abs(arr.get(arr.size() - 1) - minDistance)));
            maxDistance = Math.max(maxDistance, arr.get(arr.size() - 1));
            minDistance = Math.min(minDistance, arr.get(0));
        }
        return ans;
    }
}