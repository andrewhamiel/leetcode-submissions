class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Vertical scanning
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String str : strs) {
                if(i >= str.length() || str.charAt(i) != c) return result.toString();
            }
            result.append(c);
        }
        return result.toString();
    }
}