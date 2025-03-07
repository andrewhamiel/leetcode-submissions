class Solution {
    public boolean isNumber(String s) {
        boolean isDigit = false, isExp = false, isSign = false, isDot = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                isDigit = true;
            }else if(c == '+' || c == '-') {
                if(i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                isSign = true;
                isDigit = false;
            }else if(c == 'e' || c == 'E') {
                if(isExp || !isDigit) return false;
                isExp = true;
                isDigit = false;
            }else if(c == '.') {
                if(isDot || isExp) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}