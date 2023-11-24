class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        Map<Integer, Integer> rank = new HashMap<>();
        for(int i = 0; i < result.length; i++) rank.putIfAbsent(result[i], rank.size() + 1);
        for(int i = 0; i < result.length; i++) result[i] = rank.get(arr[i]);
        return result;
    }
}