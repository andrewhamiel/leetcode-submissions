class Solution {
    public int countElements(int[] arr) {
        int[] freq = new int[1001];
        for(int num : arr) freq[num]++;

        int result = 0;
        for(int i = 0; i < freq.length - 1; i++){
            if(freq[i] > 0 && freq[i + 1] > 0) result+= freq[i]; 
        }
        return result;
    }
}