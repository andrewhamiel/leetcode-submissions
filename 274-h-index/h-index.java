class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for(int i = 0; i < citations.length; i++){
            hIndex = Math.max(hIndex, Math.min(citations[i], citations.length - i));
        }
        return hIndex;
    }
}