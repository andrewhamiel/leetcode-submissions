class Solution {
    private List<String> result = new ArrayList<>();
    private String digits = "";
    private static final Map<Character, List<Character>> DIGIT_MAP = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'), 
            '9', List.of('w', 'x', 'y', 'z'));

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        backtrack(new StringBuilder(), 0);
        return result;   
    }

    private void backtrack(StringBuilder sb, int ind) {
        if(ind == digits.length()) {
            if(!sb.isEmpty()) result.add(sb.toString());
            return;
        }

        int currLength = sb.length();
        for(char c : DIGIT_MAP.get(digits.charAt(ind))) {
            sb.append(c);
            backtrack(sb, ind + 1);
            sb.deleteCharAt(currLength);
        }
    }
}