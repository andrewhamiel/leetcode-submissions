class Solution {
    public int longestRepeatingSubstring(String s) {
        int left = 0, right = s.length();
        while(left <= right){
            int mid = left + (right-left)/2;
            if(search(mid, s.length(), s) != -1) left = mid + 1;
            else right = mid - 1;
        }
        return left - 1;
    }
    
    private int search(int length, int n, String s){
        Set<String> seen = new HashSet();
        for(int start = 0; start < n - length + 1; start++){
            String tmp = s.substring(start, start+length);
            if(seen.contains(tmp)) return start;
            seen.add(tmp);
        }
        return -1;
    }
}