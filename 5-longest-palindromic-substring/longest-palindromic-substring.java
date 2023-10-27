class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        return manacher(s);
    }
    
    private String manacher(String s){
        String t = preprocess(s);
        int[] len = new int[t.length()];
        int maxLength = 0, left = 0, right = 0, index = 0;
        int C = 0, R = 0;
        for(int i = 1; i < t.length() - 1; i++){
            //Avoid 2*C - i overflow
            int j = 2 * C - i;
            if(i < R) len[i] = Math.min(len[j], R - i);
            //Process around center
            while(t.charAt(i+len[i]) == t.charAt(i-len[i])) len[i]++;
            //If expands beyond boundary, update center and right
            if(i >= R){
                C = i;
                R = i + len[i];
            }
            //Post processing
            if(len[i] > maxLength){
                maxLength = len[i] - 1;
                index = i;
            }
        }
        left = (index - maxLength - 1)/2;
        right = left + maxLength;
        return s.substring(left, right);
    }
    
    private String preprocess(String s){
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i = 0; i < s.length(); i++){
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        sb.append('$');
        return sb.toString();
    }
}