class Solution {
    List<String> combs = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return combs;
        Map<Character, List<Character>> map = getChars();
        helper(0, digits, new StringBuilder(), map);
        return new ArrayList<>(combs);
    }

    private void helper(int ind, String digits, StringBuilder result, Map<Character, List<Character>> map){
        if(result.length() == digits.length()){
            combs.add(result.toString());
            return;
        }

        char digit = digits.charAt(ind);
        List<Character> list = map.get(digit);
        int currLength = result.length();
        for(int i = 0; i < list.size(); i++){
            result.append(list.get(i));
            helper(ind + 1, digits, result, map);
            result.deleteCharAt(result.length() - 1);
        }
    }

    private Map<Character, List<Character>> getChars(){
        Map<Character, List<Character>> map = new HashMap<>();
        char c = 'a';
        for(char i = '2'; i <= '9'; i++){
            List<Character> letters = new ArrayList<>();
            for(int j = 0; j < 3; j++) letters.add(c++);
            if(i == '7' || i == '9') letters.add(c++);
            map.put(i, letters);
        }
        return map;
    }
}