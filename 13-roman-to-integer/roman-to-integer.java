class Solution {
    Map<Character, Set<Character>> prefixNumerals = Map.of('I', Set.of('V', 'X'), 'X', Set.of('L', 'C'), 'C', Set.of('D', 'M'));
    Map<Character, Integer> values = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) 
            result+= prefixNumerals.containsKey(s.charAt(i)) ? getPrefixVal(i, s) : values.get(s.charAt(i));
        return result;
    }

    /*
    If we are at last character in string or following character is not present (ie 'I' followed by 'I'), return value as is.
    Otherwise, return value multiplied by -1.
    */
    private int getPrefixVal(int i, String s){
        return i == s.length() - 1 || !prefixNumerals.get(s.charAt(i)).contains(s.charAt(i + 1)) 
            ? values.get(s.charAt(i)) : values.get(s.charAt(i)) * -1;
    }
}