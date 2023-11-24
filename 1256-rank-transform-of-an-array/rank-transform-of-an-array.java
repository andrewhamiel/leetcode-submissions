class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copied = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copied);
        Map<Integer, Integer> rank = new HashMap<>();
        for(int i = 0; i < copied.length; i++){
            rank.putIfAbsent(copied[i], rank.size() + 1);
        }
        for(int i = 0; i < arr.length; i++) copied[i] = rank.get(arr[i]);
        return copied;
    }
}