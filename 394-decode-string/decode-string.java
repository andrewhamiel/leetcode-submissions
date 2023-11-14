class Solution {
    private int ind = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        while(ind < s.length() && s.charAt(ind) != ']'){
            if(!Character.isDigit(s.charAt(ind))) sb.append(s.charAt(ind++));
            else{
                int k = 0;
                while(ind < s.length() && Character.isDigit(s.charAt(ind))){
                    k*= 10;
                    k+= s.charAt(ind++) - '0';
                }
                ind++; //ignore opening bracket
                String decodedString = decodeString(s);
                ind++; //ignore closing bracket
                while(k-- > 0) sb.append(decodedString);
            }
        }
        return sb.toString();
    }
}