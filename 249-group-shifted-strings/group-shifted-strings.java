class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String hash = getHash(str);
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }
        result.addAll(map.values());
        return result;
    }

    private String getHash(String str) {
        StringBuilder sb = new StringBuilder();
        char first = str.charAt(0);
        for(char c : str.toCharArray()) {
            sb.append(getShiftedChar(c, first));
        }
        return sb.toString();
    }

    private char getShiftedChar(char c, char first) {
        int preMod = c - first - 'a';
        int preShift = preMod % 26;
        return (char) (preShift + 'a');
    }
}