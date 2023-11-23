class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return result;
        populateMap();
        backtrack(0, digits, new StringBuilder());
        return result;
    }

    private void backtrack(int ind, String digits, StringBuilder sb){
        if(ind == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char c : map.get(digits.charAt(ind))){
            sb.append(c);
            backtrack(ind + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void populateMap(){
        char c = 'a';
        for(char digit = '2'; digit <= '9'; digit++){
            List<Character> letters = new ArrayList<>();
            for(int i = 0; i < 3; i++) letters.add(c++);
            if(digit == '7' || digit == '9') letters.add(c++);
            map.put(digit, letters);
        }
    }
}