class Solution {
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        public TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        //Construct TrieNode: O(m * k)
        TrieNode root = new TrieNode();
        for(String word : wordDict){
            TrieNode curr = root;
            for(Character c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        List<String> ans = new ArrayList<>();
        dp(s, new StringBuilder(), root, ans);
        return ans;
    }

    private void dp(String s, StringBuilder sb, TrieNode root, List<String> ans){
        //memo condition
        if(s.length() == 0 && !sb.isEmpty()) {
            ans.add(sb.toString());
            return;
        }

        TrieNode curr = root;

        //check if is word
        for(int i = 0; i < s.length(); i++){
            
            if(!curr.children.containsKey(s.charAt(i))) return;
            curr = curr.children.get(s.charAt(i));
            sb.append(s.charAt(i));
            if(curr.isWord){
                //two choices: use and don't use
                //1. use
                StringBuilder usingWord = new StringBuilder(sb);
                
                if(i != s.length() - 1)usingWord.append(" ");
                dp(s.substring(i+1), usingWord, root, ans);
                //2. don't use. Just continue
            }
        }
    }
}