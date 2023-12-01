class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < result.length ; i++) map.putIfAbsent(result[i], map.size() + 1);
        for(int i = 0; i < result.length; i++) result[i] = map.get(arr[i]);
        return result;
    }
}