class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int num : nums) freq[num]++;
        int maxFreq = Integer.MIN_VALUE;
        for(int i = 0; i < freq.length; i++) maxFreq = Math.max(maxFreq,freq[i]);

        int result = 0;
        for(int i = 0; i < freq.length; i++) if(freq[i] == maxFreq) result+= maxFreq;
        return result;
    }
}