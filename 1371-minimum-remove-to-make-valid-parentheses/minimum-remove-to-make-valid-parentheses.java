class Solution {
    public String minRemoveToMakeValid(String s) {
        //1. Remove invalid ')'
        StringBuilder sb = new StringBuilder();
        int leftParens = 0, balance = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                leftParens++;
                balance++;
            }else if(c == ')') {
                if(balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }

        //2. Remove extra rightmost '('
        StringBuilder result = new StringBuilder();
        int leftRemaining = leftParens - balance;
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == '(') {
                if(leftRemaining == 0) continue;
                leftRemaining--;
            }
            result.append(c);
        }

        return result.toString();
    }
}