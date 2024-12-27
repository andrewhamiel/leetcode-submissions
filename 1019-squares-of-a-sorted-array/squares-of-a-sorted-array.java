class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] freqs = new int[10001];
        for(int num : nums) freqs[Math.abs(num)]++;

        int[] result = new int[nums.length];
        int ind = 0;
        for(int i = 0; i < freqs.length; i++) {
            while(freqs[i] > 0) {
                result[ind++] = i * i;
                freqs[i]--;
            }
        }
        return result;
    }
}