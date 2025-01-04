class Solution {
    public String countAndSay(int n) {
        //1. Base Cases
        if(n == 0) return "";
        if(n == 1) return "1";

        //2. Recursion
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 0;
        char prev = s.charAt(0);

        //3. Count
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == prev) count++;
            else {
                //4. Append 
                result.append(count);
                result.append(prev);
                //5. Reset variables 
                count = 1;
                prev = curr;
            }
        }

        //6. Append last count
        result.append(count);
        result.append(prev);

        return result.toString();
    }
}