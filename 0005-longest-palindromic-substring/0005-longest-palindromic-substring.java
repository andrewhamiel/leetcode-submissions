class Solution {
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        return manacher(s);
    }
    
    private String preProcess(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < length; i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
    
    private String manacher(String s) {
        String t = preProcess(s);
        int length = t.length();
        int[] len = new int[length];
        int maxLength = 0, index = 0, left = 0, right = 0;
        int C = 0, R = 0;
        for (int i = 1; i < length - 1; i++) {
            // avoid (2 * C - i) overflow 
            int j = 2*C-i;
            if (i < R)
                len[i] = Math.min(len[j], R - i);
            // Expand around the center
            while (t.charAt(i + len[i]) == t.charAt(i - len[i]))
                len[i]++;
            // if the expansion crosess current length then update the center and right
            if (i >= R) {
                C = i;
                R = i + len[i];
            }
            //Post-processing
            if (len[i] > maxLength) {
                maxLength = len[i] - 1;
                index = i;
            }
        }
        left = (index - maxLength - 1) / 2;
        right = left + maxLength;
        return s.substring(left, right);
    }
    
    
    
}