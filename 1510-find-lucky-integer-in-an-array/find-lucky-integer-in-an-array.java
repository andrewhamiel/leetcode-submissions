class Solution {
    public int findLucky(int[] arr) {
        int[] freqs = new int[501];
        for(int num : arr) freqs[num]++;
        int luckyNum = -1;
        for(int i = 1; i < freqs.length; i++) if(freqs[i] == i) luckyNum = i;
        return luckyNum;
    }
}