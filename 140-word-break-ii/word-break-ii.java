class Solution {
    private TrieNode root = new TrieNode();
    private String s = "";
    private List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        //1. Build Trie
        this.s = s;
        for(String word : wordDict) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }    

        //2. Top-Down DP
        dp(0, new StringBuilder());
        return result;
    }

    private void dp(int ind, StringBuilder sb) {
        if(ind == s.length()) {
            result.add(sb.toString());
            return;
        }

        TrieNode curr = root;
        for(int i = ind; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!curr.children.containsKey(c)) return;

            sb.append(c);
            curr = curr.children.get(c);

            if(curr.isWord) {
                //2 options: use or do not use 
                //1. Use 
                StringBuilder using = new StringBuilder(sb);
                if(i != s.length() - 1) using.append(" "); //If not at end of string 
                dp(i + 1, using);
                //2. Do not use. Just continue
            }
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}