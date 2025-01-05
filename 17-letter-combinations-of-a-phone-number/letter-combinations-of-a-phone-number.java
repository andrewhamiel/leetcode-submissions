class Solution {
    private List<String> result = new ArrayList<>();
    private String digits = "";
    private Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        populateMap();    
        backtrack(new StringBuilder(), 0);
        return result;
    }

    private void backtrack(StringBuilder sb, int ind) {
        //1. Exit condition
        if(ind == digits.length()) {
            if(!sb.isEmpty()) result.add(sb.toString());
            return;
        }

        int currLength = sb.length();
        for(char letter : map.get(digits.charAt(ind))) {
            sb.append(letter);
            backtrack(sb, ind + 1);
            sb.deleteCharAt(currLength);
        }
    }

    private void populateMap() {
        char letter = 'a';
        for(char digit = '2'; digit <= '9'; digit++) {
            List<Character> letters = new ArrayList<>();
            for(int i = 0; i < 3; i++) letters.add(letter++);
            if(digit == '7' || digit == '9') letters.add(letter++);
            map.put(digit, letters);
        }
    }
}