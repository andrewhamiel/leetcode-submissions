class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count+= countPalindromesFromCenter(s, i, i); //Odd-length palindromes. Center length == 1
            count+= countPalindromesFromCenter(s, i, i+1); //Even-length palindromes. Center length == 2
        }
        return count;
    }
    
    private int countPalindromesFromCenter(String s, int start, int end){
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) count++;
        return count;
    }
}