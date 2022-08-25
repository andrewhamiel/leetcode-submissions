class Solution {
    private String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    private Set<String> seen = new HashSet();
    
    public int uniqueMorseRepresentations(String[] words) {
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                sb.append(morse[word.charAt(i) - 'a']);
            }
            if(!seen.contains(sb.toString())) seen.add(sb.toString());
        }
        return seen.size();
    }
}