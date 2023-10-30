class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> collisions = new HashMap<>();
        for(String str : strings){
            String hash = getHash(str);
            collisions.putIfAbsent(hash, new ArrayList<>());
            collisions.get(hash).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : collisions.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    private String getHash(String str){
        StringBuilder sb = new StringBuilder();

        int shift = (int)(str.charAt(0) - 'a');
        for(Character c : str.toCharArray()){
            sb.append(getValue(c-'a', shift));
        }
        return sb.toString();
    }

    private char getValue(int c, int shift){
        int preMod = (int)(c - shift + 26);
        int preShift = preMod % 26;
        return (char)(preShift + 'a');
    }
}