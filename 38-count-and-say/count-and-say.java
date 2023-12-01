class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        return dp(n);
    }

    private String dp(int n){
        if(n == 1) return "1";

        String s = dp(n - 1);
        StringBuilder result = new StringBuilder();
        char c = s.charAt(0);
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) count++;
            else{
                result.append(count);
                result.append(c);
                count = 1;
                c = s.charAt(i);
            }
        }
        result.append(count);
        result.append(c);
        return result.toString();
    }
}