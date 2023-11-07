class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<Integer, List<Character>> map = populateMap();
        dfs(0, digits.toCharArray(), result, map);
        return result;
    }

    private void dfs(int start, char[] digits, List<String> result, Map<Integer, List<Character>> map){
        if(start >= digits.length){
            result.add(new String(digits));
            return;
        }

        for(int i = start; i < digits.length; i++){
            char c = digits[i];
            if(Character.isDigit(c)){
                for(Character letter : map.get((int)(c - '0'))){
                    digits[i] = letter;
                    dfs(start+1, digits, result, map);
                }
                digits[i] = c;
            }
        }
    }

    private Map<Integer, List<Character>> populateMap(){
        Map<Integer, List<Character>> map = new HashMap<>();
        char c = 'a';
        for(int i = 2; i <= 9; i++){
            List<Character> list = new ArrayList<>();
            for(int j = 0; j < 3; j++) list.add(c++);
            if(i == 7 || i ==9) list.add(c++);
            map.put(i, list);
        }
        return map;
    }
}