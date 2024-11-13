class Solution {
    private TrieNode root;
    private String s;
    Set<String> result = new HashSet<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        //1. Build Trie
        root = new TrieNode();
        for(String word : wordDict) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        //2. DP 
        dp(0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dp(int ind, StringBuilder sb) {
        if(ind >= s.length() && !sb.isEmpty()) {
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
                StringBuilder using = new StringBuilder(sb);
                if(i != s.length() - 1) using.append(" ");
                //1. Use 
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