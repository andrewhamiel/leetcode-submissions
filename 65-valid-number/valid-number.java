class Solution {
    public boolean isNumber(String s) {
        boolean isDigit = false, isExp = false, isDot = false, isSign = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) isDigit = true;
            else if(c == 'e' || c == 'E') {
                if(isExp || !isDigit) return false;
                isDigit = false;
                isExp = true;
            }else if(c == '+' || c == '-') {
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                isDigit = false;
                isSign = true;
            }else if(c == '.') {
                if(isDot || isExp) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}