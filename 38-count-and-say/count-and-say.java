class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        return dp(n);
    }

    private String dp(int n) {
        //1. Base case 
        if(n == 1) return "1";

        //2. Recursion
        StringBuilder result = new StringBuilder();
        String s = dp(n - 1);
        int count = 0;
        char prev = s.charAt(0);

        //3. Count Variables
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == prev) count++;
            else {
                //5. Append
                result.append(count);
                result.append(prev);
                //6. Reset variables
                count = 1;
                prev = c;
            }
        }
        //7. Set final num
        result.append(count);
        result.append(prev);

        return result.toString();
    }
}