class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int start = q.poll();
            if(start == s.length()) return true;

            for(int end = start + 1; end < seen.length; end++){
                if(seen[end]) continue;

                if(words.contains(s.substring(start, end))){
                    seen[end] = true;
                    q.add(end);
                }
            }
        }
        return false;

    }
}