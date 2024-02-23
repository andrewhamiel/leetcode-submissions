class MagicDictionary {
    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();    
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
    }
    
    public boolean search(String searchWord) {
        TrieNode curr = root;
        return isOneEquals(curr, searchWord, false);
    }

    private boolean isOneEquals(TrieNode curr, String originalSubstr, boolean isChanged){
        if(originalSubstr == null || originalSubstr.isEmpty()) return isChanged && curr.isWord;

        if(isChanged){
            if(!curr.children.containsKey(originalSubstr.charAt(0))) return false;
            return isOneEquals(curr.children.get(originalSubstr.charAt(0)), originalSubstr.substring(1), isChanged);
        }else{
            boolean changeLater = false;
            if(curr.children.containsKey(originalSubstr.charAt(0))) changeLater = isOneEquals(curr.children.get(originalSubstr.charAt(0)), originalSubstr.substring(1), isChanged);
            boolean changeNow = false;
            for(char c : curr.children.keySet()){
                if(c != originalSubstr.charAt(0) && isOneEquals(curr.children.get(c), originalSubstr.substring(1), true)){
                    changeNow = true;
                    break;
                }
            }
            return changeNow || changeLater;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */