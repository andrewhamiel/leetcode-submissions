class Solution {
    public String countAndSay(int n) {
        //1. Base cases
        if(n == 0) return "";
        if(n == 1) return "1";
        ;
        //2. Recursion
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        //3. Count variables
        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == prev) count++;
            else {
                //4. Append to result
                result.append(count);
                result.append(prev);
                //5. Reset variables
                prev = curr;
                count = 1;
            }
        }

        //6. Append last variable
        result.append(count);
        result.append(prev);

        return result.toString();
    }
}