class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    private List<int[]> freqs = new ArrayList<>();

    public int minStickers(String[] stickers, String target) {
        for(String sticker : stickers) {
            int[] freq = new int[26];
            for(char c : sticker.toCharArray()) freq[c - 'a']++;
            freqs.add(freq);
        }

        int minStickers = backtrack(target, null);
        return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
    }

    private int backtrack(String target, int[] currFreq) {
        if(memo.containsKey(target)) return memo.get(target.toString());

        StringBuilder remain = new StringBuilder();
        int minStickers = 0;
        if(currFreq != null) {
            for(char c : target.toCharArray()) {
                if(currFreq[c - 'a'] > 0){
                    currFreq[c - 'a']--;
                    minStickers = 1;
                } 
                else remain.append(c);
            }
        }else remain = new StringBuilder(target);

        if(!remain.isEmpty()) {
            int minAdditional = Integer.MAX_VALUE;
            for(int[] freq : freqs) {
                if(freq[remain.charAt(0) - 'a'] > 0) {
                    minAdditional = Math.min(minAdditional, backtrack(remain.toString(), freq.clone()));                    
                }
            }
            memo.put(remain.toString(), minAdditional);
            minStickers = minAdditional == Integer.MAX_VALUE ? Integer.MAX_VALUE : minStickers + minAdditional;
        }
        return minStickers;
    }
}