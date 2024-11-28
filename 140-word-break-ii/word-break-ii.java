class Solution {
    private Set<String> result = new HashSet<>();
    private TrieNode root = new TrieNode();
    private String s = "";

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

        //2. Backtrack
        backtrack(0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void backtrack(int ind, StringBuilder sb) {
        if(ind == s.length() && !sb.isEmpty()) {
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
                if(i != s.length() - 1) using.append(" "); //if not at end of string 
                //1. Use 
                backtrack(i + 1, using);
                //2. Do not use. Just continue
            }
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}