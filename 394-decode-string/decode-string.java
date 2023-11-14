class Solution {
    int ind = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        while(ind < s.length() && s.charAt(ind) != ']'){
            if(!Character.isDigit(s.charAt(ind))) result.append(s.charAt(ind++));
            else{
                int k = 0;
                while(ind < s.length() && Character.isDigit(s.charAt(ind))){
                    k*= 10;
                    k+= s.charAt(ind++) - '0';
                }
                ind++; //ignore opening bracket
                String decodedString = decodeString(s);
                ind++; //ignore closing bracket
                while(k-- > 0) result.append(decodedString);
            }
        }    
        return result.toString();
    }
}