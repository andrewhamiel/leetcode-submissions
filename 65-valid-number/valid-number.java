class Solution {
    public boolean isNumber(String s) {
        boolean isDigit = false, isExp = false, isSign = false, isDot = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) isDigit = true;
            else if(c == '+' || c == '-') {
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                isSign = true;
                isDigit = false;
            }else if(c == 'E' || c == 'e') {
                if(!isDigit || isExp) return false;
                isDigit = false;
                isExp = true;
            }else if(c == '.') {
                if(isDot || isExp) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}