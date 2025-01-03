class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        //1. Build TrieNode
        TrieNode root = new TrieNode();
        for(String word : wordDict){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        //2. Bottom-up DP
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || dp[i - 1]){
                TrieNode curr = root;
                for(int j = i; j < s.length(); j++){
                    char c=  s.charAt(j);
                    if(!curr.children.containsKey(c)) break;

                    curr = curr.children.get(c);
                    if(curr.isWord) dp[j] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}