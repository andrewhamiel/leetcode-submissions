class Solution {
    List<int[]> stickerFreqs = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();
    public int minStickers(String[] stickers, String target) {
        //Add frequencies for each sticker first
        for(String sticker : stickers){
            int[] freq = new int[26];
            for(int i = 0; i < sticker.length(); i++){
                freq[(int)(sticker.charAt(i) - 'a')]++;
            }
            stickerFreqs.add(freq);
        }

        int result = dp(target, null);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dp(String remainingTarget, int[] currentSticker){
        if(remainingTarget.isEmpty()) return 0;
        if(memo.containsKey(remainingTarget)) return memo.get(remainingTarget);

        //If we have a current sticker, try to extract as much as we can
        StringBuilder remain = new StringBuilder();
        int stickersUsed = currentSticker != null ? 1 : 0;
        if(currentSticker != null){
            for(Character c : remainingTarget.toCharArray()){
                if(currentSticker[c - 'a'] > 0) currentSticker[c- 'a']--;
                else remain.append(c);
            }
        }else remain.append(remainingTarget);
        
        if(!remain.isEmpty()){
            int used = Integer.MAX_VALUE;
            for(int[] freq : stickerFreqs){
                if(freq[remain.charAt(0) - 'a'] > 0){
                    used = Math.min(used, dp(remain.toString(), freq.clone()));
                }
            }
            memo.put(remain.toString(), used);
            stickersUsed = used == Integer.MAX_VALUE ? used : stickersUsed + used;
        }
        
        return stickersUsed;
    }
}