class Solution {
    int index = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']'){
            if(!Character.isDigit(s.charAt(index))) result.append(s.charAt(index++));
            else{
                int k = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    k*= 10;
                    k+= s.charAt(index++) - '0';
                }
                //ignore openitng bracket
                index++;
                String decodedString = decodeString(s);
                //ignore closing bracket
                index++;
                while(k-- > 0) result.append(decodedString);
            }
        }
        return result.toString();    
    }
}