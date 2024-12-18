class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreqs = new HashMap<>();
        for(char c : t.toCharArray()) {
            tFreqs.put(c, tFreqs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> seen = new HashMap<>();
        int required = tFreqs.size(), counted = 0;
        int leftInd = 0, rightInd = 0, minWindow = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(tFreqs.containsKey(c)) {
                seen.put(c, seen.getOrDefault(c, 0) + 1);
                if(seen.get(c).intValue() == tFreqs.get(c).intValue()) counted++;
            }

            while(left <= right && counted == required) {
                c = s.charAt(left);
                if(right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    leftInd = left;
                    rightInd = right;
                }

                if(tFreqs.containsKey(c)) {
                    seen.put(c, seen.getOrDefault(c, 0) - 1);
                    if(seen.get(c).intValue() < tFreqs.get(c).intValue()) counted--;
                }
                left++;
            }
            right++;
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(leftInd, rightInd + 1);
    }
}