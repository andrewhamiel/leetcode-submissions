class Solution {
    Map<String, Integer> memo = new HashMap();
    Set<String> wordsPresent = new HashSet();
    
    public int longestStrChain(String[] words) {
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for(String word : words) ans = Math.max(ans, dfs(word));
        return ans;
    }
    
    private int dfs(String word){
        if(memo.containsKey(word)) return memo.get(word);
        
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(word);
        
        for(int i = 0; i < word.length(); i++){
            sb.deleteCharAt(i);
            if(wordsPresent.contains(sb.toString())){
                int currentLength = 1 + dfs(sb.toString());
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, maxLength);
        return maxLength;
    }
}