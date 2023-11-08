class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        return dp(n);
    }

    private String dp(int n){
        if(n == 1) return "1";

        StringBuilder sb = new StringBuilder();
        String s = dp(n - 1);
        int count = 0;
        char c = s.charAt(0);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) count++;
            else{
                sb.append(count).append(c);

                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}