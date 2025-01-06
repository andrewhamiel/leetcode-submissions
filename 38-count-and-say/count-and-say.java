class Solution {
    public String countAndSay(int n) {
        //1. Base cases
        if(n == 0) return "";
        if(n == 1) return "1";

        //2. Recursion
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        //3. Count variables
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == prev) count++;
            else {
                result.append(count);
                result.append(prev);
                count = 1;
                prev = c;
            }
        }

        //4. Append last variable
        result.append(count);
        result.append(prev);

        return result.toString();
    }
}