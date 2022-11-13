class Solution {
    public String reverseWords(String s) {
        String[] split = s.split("\s");
        StringBuilder sb = new StringBuilder();
        for(String word : split){
            if(!word.isBlank() && !word.isEmpty()) {
                sb.insert(0, " ");
                sb.insert(0, word);
            }          
        }
        return !sb.toString().isEmpty() && sb.length() > 1 ? sb.toString().substring(0, sb.length() - 1) : sb.toString();
    }
}