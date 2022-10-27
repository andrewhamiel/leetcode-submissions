class Solution {
    private String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0; i < symbols.length && s.length() > 0; i++){
            while(s.length() > 0 && s.charAt(0) == symbols[i].charAt(0) && s.indexOf(symbols[i]) != -1){
                if(symbols[i].length() == 1) s = s.substring(1);
                else if(symbols[i].length() == 2) s = s.substring(2);
                num+=values[i];
            }
        }
        return num;
    }
}