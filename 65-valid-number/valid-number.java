class Solution {
    //1. Digit
    //2. Exponent
    //3. Sign
    //4. Dot
    public boolean isNumber(String s) {
        boolean isDigit = false, isExponent = false, isSign = false, isDot = false;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) isDigit = true;
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(i == 0 || isExponent || !isDigit) return false;
                isExponent = true;
                isDigit = false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
                isSign = true;
                isDigit = false;
            }else if(s.charAt(i) == '.'){
                if(isDot || isExponent) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}