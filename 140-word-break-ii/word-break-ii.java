class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        //1. Build Trie
        TrieNode root = new TrieNode();
        for(String word : wordDict){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        //2. Top Down DP
        List<String> result = new ArrayList<>();    
        this.s = s;
        helper(0, new StringBuilder(), root, result);
        return result;
    }

    private void helper(int ind, StringBuilder sb, TrieNode root, List<String> result){
        if(ind == s.length() && !sb.isEmpty()){
            result.add(sb.toString());
            return;
        }

        TrieNode curr = root;
        for(int i = ind; i < s.length(); i++){
            char c = s.charAt(i);
            if(!curr.children.containsKey(c)) break;

            curr = curr.children.get(c);
            sb.append(c);
            if(curr.isWord){
                //2 options: use or do not use
                //1. use
                StringBuilder using = new StringBuilder(sb);
                if(i != s.length() - 1) using.append(" ");
                helper(i + 1, using, root, result);
                //2. do not use. just continue
            }
        }
    }
}