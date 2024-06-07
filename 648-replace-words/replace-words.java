class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
        
        String[] words = sentence.split("\\s");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){       
                if(!curr.children.containsKey(c) || curr.isWord) break;
                sb.append(c);
                curr = curr.children.get(c);
            }
            if(curr.isWord) result.append(sb).append(" ");
            else result.append(word).append(" ");
        }
        if(!result.isEmpty()) result.deleteCharAt(result.length() -1);
        return result.toString();
    }
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}