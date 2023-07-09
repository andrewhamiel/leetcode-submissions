class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k >= s.length()) return s.length();
        
        int left = k, right = s.length();
        while (left < right) {
            int mid = (left + right + 1) / 2;
            
            if (isValid(s, mid, k)) left = mid;
            else right = mid - 1;
        }
        
        return left;
    }
    
    private boolean isValid(String s, int size, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        
        if (counter.size() <= k) return true;
        
        for (int i = size; i < s.length(); i++) {
            //move right side of window
            char c1 = s.charAt(i);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            
            //move left side of window
            char c2 = s.charAt(i - size);
            counter.put(c2, counter.getOrDefault(c2, 0) - 1);
            if (counter.get(c2) == 0) counter.remove(c2);

            if (counter.size() <= k) return true;
        }
        
        return false;
    }
}