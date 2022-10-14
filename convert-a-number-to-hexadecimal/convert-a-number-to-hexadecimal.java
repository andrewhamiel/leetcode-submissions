class Solution {
    char[] hex = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if (num == 0) return "0";       
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        
        while (count < 8 && num != 0) {
            strBuilder.append(hex[num & 15]); // Gets complement between 0-15
            num = num >> 4; // Read 4 bits eeach time
            count++;
        }
        return strBuilder.reverse().toString();
    }
}