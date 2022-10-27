class Solution {
    public int myAtoi(String s) {
        //1: trim
        s = s.trim();
        if(s.length() == 0) return 0;
        //2: check sign
        boolean isNeg = false;
        if(s.charAt(0) == '-'){
            isNeg = true;
            s = s.substring(1);
        }else if (s.charAt(0) == '+'){
            s = s.substring(1);
        }
        if(s.length() == 0) return 0;
        //3: parseInts until non-numeric character
        String numStr = "";
        boolean reachedNumber = false;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                numStr+=s.charAt(i);
                reachedNumber = true;
            }else if(numStr.length() == 0){
                return 0;
            }
            else {
                break;
            }
        }
        //4: make negative if needed
        if(isNeg) numStr = "-" + numStr;
        
        //5: try to parse int, return max/min if out of range
        try{
            return Integer.parseInt(numStr);
        }catch(NumberFormatException e){
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}