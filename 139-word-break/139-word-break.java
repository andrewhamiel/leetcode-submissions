class Solution {
    Set<String> words;
    Map<String, Boolean> map = new HashMap();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet(wordDict);
        return dp(s, new StringBuilder());
    }
    
    private boolean dp(String str, StringBuilder curr){
        boolean hasKey = false;
        if(curr.length() == str.length()) return words.contains(curr.toString());
        if(words.contains(curr.toString())) 
           hasKey = dp(str.substring(curr.length()), new StringBuilder());
        if(map.containsKey(str)) return map.get(str);
        hasKey = hasKey || dp(str, curr.append(str.charAt(curr.length())));
        map.put(str, hasKey);
        return hasKey;
    }
}