class Solution {
    List<int[]> freqs = new ArrayList<>();
    Map<String, Integer> memo = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        for(String sticker : stickers){
            int[] freq = new int[26];
            for(Character c : sticker.toCharArray()) freq[c - 'a']++;
            freqs.add(freq);
        }
        int ans = helper(target, null);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(String target, int[] currSticker){
        if(target.length() == 0) return 0;
        if(memo.containsKey(target)) return memo.get(target);
        int minStickers = 0;
        StringBuilder remainingTarget = new StringBuilder();
        if(currSticker != null){
            for(int i = 0; i < target.length(); i++){
                if(currSticker[target.charAt(i) - 'a'] > 0){
                    currSticker[target.charAt(i) - 'a']--;
                    minStickers = 1;
                }else remainingTarget.append(target.charAt(i));
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
            minStickers = minAdditional == Integer.MAX_VALUE ? Integer.MAX_VALUE : minStickers + minAdditional;

        }
        return minStickers;
    }
}