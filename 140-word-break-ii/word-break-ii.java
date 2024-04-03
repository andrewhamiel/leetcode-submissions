class Solution {
    TrieNode root;
    String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        //1. Build Trie
        root = new TrieNode();
        for(String word : wordDict){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        //2. Top-down DP
        this.s = s;
        List<String> result = new ArrayList<>();
        dp(0, new StringBuilder(), result);
        return result;
    }

    private void dp(int ind, StringBuilder sb, List<String> result){
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
                //2 options: use or don't use
                //1. Use
                StringBuilder using = new StringBuilder(sb);
                if(i != s.length() - 1) using.append(" ");
                dp(i + 1, using, result);
                //2. Don't use. Just continue
            }
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}