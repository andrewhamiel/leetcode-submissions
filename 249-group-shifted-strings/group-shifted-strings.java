class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> collisions = new HashMap<>();
        for(String str : strings){
            String hash = getHash(str);
            collisions.putIfAbsent(hash, new ArrayList<>());
            collisions.get(hash).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(String hash : collisions.keySet()) result.add(collisions.get(hash));
        return result;
    }

    private String getHash(String str){
        char[] arr = str.toCharArray();
        int shift = arr[0] - 'a';
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(getShift(shift, arr[i]));
        }
        return sb.toString();
    }

    private char getShift(int shift, char c){
        int preMod = (int)(c - 'a') - shift + 26;
        int preShift = preMod % 26;
        return (char)(preShift + 'a');
    }
}