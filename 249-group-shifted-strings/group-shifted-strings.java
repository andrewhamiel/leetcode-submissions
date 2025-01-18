class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String hash = getHash(str);
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }

    private String getHash(String str) {
        StringBuilder result = new StringBuilder();
        char firstChar = str.charAt(0);
        for(char c : str.toCharArray()) {
            result.append(getShiftedChar(c, firstChar));
        }
        return result.toString();
    }

    private char getShiftedChar(char c, char firstChar) {
        int preMod = c - firstChar - 'a' + 26;
        int preShift = preMod % 26;
        return (char) (preShift + 'a');
    }
}