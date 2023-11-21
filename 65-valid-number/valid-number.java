class Solution {
    //4 cases
    //1. Number
    //2. Exponent
    //3. Sign
    //4. Dot
    public boolean isNumber(String s) {
        boolean isDigit = false, isExponent = false, isSign = false, isDot = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) isDigit = true;
            else if(c == 'E' || c == 'e'){
                if(i == 0 || !isDigit || isExponent) return false;
                isExponent = true;
                isDigit = false;
            }else if(c == '+' || c == '-'){
                if(i > 0 && s.charAt(i-1) != 'E' && s.charAt(i-1) != 'e') return false;
                isSign = true;
                isDigit = false;
            }else if(c == '.'){
                if(isExponent || isDot) return false;
                isDot = true;
            }else return false;
        }
        return isDigit;
    }
}