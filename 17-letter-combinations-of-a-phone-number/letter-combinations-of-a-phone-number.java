class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        populateMap(map);
        List<String> result = new ArrayList<>();
        dfs(0, digits.toCharArray(), result, map);
        return result;
    }

    private void dfs(int start, char[] digits, List<String> result, Map<Integer, List<Character>> map){
        if(start == digits.length){
            result.add(new String(digits));
            return;
        }

        for(int i = start; i < digits.length; i++){
            Character c = digits[i];
            if(Character.isDigit(c)){
                for(Character digit : map.get((int)(c - '0'))){
                    digits[i] = digit;
                    dfs(start+1, digits, result, map);
                }
            }
            digits[i] = c;
        }
    }

    private void populateMap(Map<Integer, List<Character>> map){
        char c = 'a';
        for(int i = 2; i <= 9; i++){
            List<Character> list = new ArrayList<>();
            for(int j = 0; j < 3; j++) list.add(c++);
            if(i == 7 || i == 9) list.add(c++);
            map.put(i, list);
        }
    }
}