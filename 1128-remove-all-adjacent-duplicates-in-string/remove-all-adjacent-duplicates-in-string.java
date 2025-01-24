class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!result.isEmpty() && result.charAt(result.length() - 1) == c) result.deleteCharAt(result.length() - 1);
            else result.append(c);
        }
        return result.toString();
    }
}