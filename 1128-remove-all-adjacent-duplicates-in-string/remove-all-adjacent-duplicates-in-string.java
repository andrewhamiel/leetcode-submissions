class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(!result.isEmpty() && result.charAt(result.length() - 1) == c) result.deleteCharAt(result.length() - 1);
            else result.append(c);
        }
        return result.toString();
    }
}