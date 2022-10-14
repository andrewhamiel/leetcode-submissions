class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        int[] manacher = manacher(s);
        int sum = 0;
        for(int i =0; i < manacher.length; i++) sum+= (manacher[i]+1)/2;
        return sum;
    }
    
    private int[] manacher(String s){
        String t = preprocess(s);
        int[] len = new int[t.length()];
        int ans = 0, left = 0, right = 0, index = 0;
        int C = 0, R = 0;
        for(int i = 1; i < t.length() - 1; i++){
            //Avoid 2*C-i overflor
            int j = 2*C - i;
            if(i < R) len[i] = Math.min(len[j], R - i);
            //Process around center
            while(t.charAt(i + len[i]+1) == t.charAt(i - len[i]-1)) len[i]++;
            //If expands beyond boundary
            if(i >= R){
                C = i;
                R = i + len[i];
            }
            
            if(len[i] > 0) ans+= len[i] == 1 ? 1 : (len[i]+1)/2;
            
        }
        return len;
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