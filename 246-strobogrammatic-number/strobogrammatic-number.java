class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder reversed = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--){
            char c = num.charAt(i);
            if(c == '0' || c == '1' || c == '8') reversed.append(c);
            else if(c == '6') reversed.append('9');
            else if(c == '9') reversed.append('6');
            else return false;
        }
        return reversed.toString().equals(num);
    }
}