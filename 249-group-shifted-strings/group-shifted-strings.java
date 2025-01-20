class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> collissions = new HashMap<>();
        for(String str : strings) {
            String hash = getHash(str);
            collissions.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(collissions.values());
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

    private char getShiftedChar(char c, char first) {
        int preMod = c - first - 'a' + 26;
        int preShift = preMod % 26;
        return (char)(preShift + 'a');
    }
}