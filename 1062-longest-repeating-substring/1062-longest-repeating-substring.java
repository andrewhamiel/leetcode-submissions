class Solution {
  
    //Binary Search + HashSet of seen strings. T: O(nlog(n))
  public int longestRepeatingSubstring(String S) {
    int left = 1, right = S.length();
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (search(mid, S.length(), S) != -1) left = mid + 1;
      else right = mid - 1;
    }

    return left - 1;
  }
    
  public int search(int L, int n, String S) {
    HashSet<String> seen = new HashSet();
    String tmp;
    for(int start = 0; start < n - L + 1; ++start) {
      tmp = S.substring(start, start + L);
      if (seen.contains(tmp)) return start;
      seen.add(tmp);
    }
    return -1;
  }
}