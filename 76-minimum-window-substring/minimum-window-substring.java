class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()) tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);

        Map<Character, Integer> seen = new HashMap<>();
        int required = tFreq.size(), counted = 0, minWindow = Integer.MAX_VALUE, leftInd = 0, rightInd = 0;
        int left = 0, right = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            if(tFreq.containsKey(c)){
                seen.put(c, seen.getOrDefault(c, 0) + 1);
                if(seen.get(c).intValue() == tFreq.get(c).intValue()) counted++;
            }

            while(left <= right && counted == required){
                c = s.charAt(left);
                if(right - left + 1 < minWindow){
                    minWindow = right - left + 1;
                    leftInd = left;
                    rightInd = right;
                }

                if(tFreq.containsKey(c)){
                    seen.put(c, seen.get(c) - 1);
                    if(seen.get(c) < tFreq.get(c)) counted--;
                }
                left++;
            }
            right++;
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(leftInd, rightInd + 1);
    }
}