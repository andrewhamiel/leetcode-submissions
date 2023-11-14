class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count+= middleOut(i, i, s); //odd count
            count+= middleOut(i, i + 1, s); //even count
        }
        return count;
    }

    private int middleOut(int left, int right, String s){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++;
        return count;
    }
}