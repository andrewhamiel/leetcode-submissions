class Solution {
    List<int[]> freqs = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        for(String sticker : stickers) {
            int[] freq = new int[26];
            for(char c : sticker.toCharArray()) {
                freq[c - 'a']++;
            }
            freqs.add(freq);
        }    

        int minStickers = backtrack(target, null);
        return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
    }

    private int backtrack(String target, int[] currSticker) {
        if(memo.containsKey(target)) return memo.get(target);

        StringBuilder remaining = new StringBuilder();
        int minStickers = 0;
        if(currSticker != null) {
            for(char c : target.toCharArray()) {
                if(currSticker[c - 'a'] > 0) {
                    currSticker[c - 'a']--;
                    minStickers = 1;
                }else remaining.append(c);
            }
        }else remaining = new StringBuilder(target);

        if(!remaining.isEmpty()) {
            int minAdditional = Integer.MAX_VALUE;
            for(int[] freq : freqs) {
                if(freq[remaining.charAt(0) - 'a'] > 0) {
                    minAdditional = Math.min(minAdditional, backtrack(remaining.toString(), freq.clone()));
                }
            }
            memo.put(remaining.toString(), minAdditional);
            minStickers = minAdditional == Integer.MAX_VALUE ? Integer.MAX_VALUE : minStickers + minAdditional;
        }
        return minStickers;
    }
}