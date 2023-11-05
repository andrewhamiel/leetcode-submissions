class Solution {
    List<int[]> freqs = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        for(String sticker : stickers){
            int[] freq = new int[26];
            for(Character c : sticker.toCharArray()) freq[c - 'a']++;
            freqs.add(freq);
        }
        int minStickers = helper(target, null);
        return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
    }

    private int helper(String target, int[] currSticker){
        if(memo.containsKey(target)) return memo.get(target);
        StringBuilder remainingTarget = new StringBuilder();
        int minStickers = 0;
        if(currSticker != null){
            for(Character c : target.toCharArray()){
                if(currSticker[c - 'a'] > 0) {
                    currSticker[c - 'a']--;
                    minStickers = 1;
                }
                else remainingTarget.append(c);
            }
        }else remainingTarget = new StringBuilder(target);

        if(!remainingTarget.isEmpty()){
            int minAdditional = Integer.MAX_VALUE;
            for(int[] freq : freqs){
                if(freq[remainingTarget.charAt(0) - 'a'] > 0){
                    minAdditional = Math.min(minAdditional, helper(remainingTarget.toString(), freq.clone()));
                }
            }
            memo.put(remainingTarget.toString(), minAdditional);
            minStickers = minAdditional == Integer.MAX_VALUE ? minAdditional : minStickers + minAdditional;
        }
        return minStickers;
    }
}