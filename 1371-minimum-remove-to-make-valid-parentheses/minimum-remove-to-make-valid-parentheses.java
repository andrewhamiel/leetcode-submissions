class Solution {
    public String minRemoveToMakeValid(String s) {
        //1. Remove all invalid ')'
        int leftParens = 0, balance = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                leftParens++;
                balance++;
            }else if(c == ')') {
                if(balance == 0) continue; //To not add paren
                balance--;
            }
            sb.append(c);
        }

        //2. Remove rightmost '('
        StringBuilder result = new StringBuilder();
        int openToKeep = leftParens - balance;
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == '(') {
                if(openToKeep == 0) continue;
                openToKeep--;
            }
            result.append(c);
        }

        return result.toString();
    }
}