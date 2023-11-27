class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(String word : wordDict){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        List<String> result = new ArrayList<>();
        dp(s, new StringBuilder(), root, result);
        return result;
    }

    private void dp(String s, StringBuilder sb, TrieNode root, List<String> result){
        if(s.length() == 0 && !sb.isEmpty()){
            result.add(sb.toString());
            return;
        }

        TrieNode curr = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!curr.children.containsKey(c)) return;

            curr = curr.children.get(c);
            sb.append(c);
            if(curr.isWord){
                //2 choices: use or don't use
                //1. use
                StringBuilder usingWord = new StringBuilder(sb);
                if(i != s.length() - 1) usingWord.append(" ");
                dp(s.substring(i + 1), usingWord, root, result);
                //2. Don't use. Just continue
            }
        }
    }
}