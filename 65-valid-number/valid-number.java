class Solution {
    //4 Cases
    //1. Digit
    //2. Exponent
    //3. Sign
    //4. Dot
    public boolean isNumber(String s) {
        boolean isDigit = false, isExponent = false, isSign = false, isDot = false;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)) isDigit = true;
            else if(c == 'e' || c == 'E'){
                if(i == 0 || isExponent || !isDigit) return false;
                isExponent = true;
                isDigit = false;
            }else if(c == '+' || c == '-'){
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
                isSign = true;
                isDigit = false;
            }else if(c == '.'){
                if(isDot || isExponent) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}