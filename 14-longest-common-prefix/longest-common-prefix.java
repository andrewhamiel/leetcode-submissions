class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean foundBreak = false;
            for(String str : strs) {
                if(i >= str.length() || str.charAt(i) != c) {
                    foundBreak = true;
                    break;
                }
            }
            if(foundBreak) return result.toString();
            result.append(c);
        }
        return result.toString();
    }
}