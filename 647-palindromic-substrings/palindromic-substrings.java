class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int oddLength = countPalindromes(i, i, s);
            int evenLength = countPalindromes(i, i + 1, s);
            count+= oddLength + evenLength;
        }
        return count;
    }

    private int countPalindromes(int left, int right, String s) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}