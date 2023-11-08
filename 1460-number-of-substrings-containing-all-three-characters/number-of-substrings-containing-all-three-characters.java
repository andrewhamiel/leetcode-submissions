class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0, right = 0, result = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            count[c - 'a']++;
            while(isValidSubstring(count)){
                result+= s.length() - right;
                count[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return result;
    }

    private boolean isValidSubstring(int[] count){
        return count[0] > 0 && count[1] > 0 && count[2] > 0;
    }
}