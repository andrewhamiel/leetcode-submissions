class Solution {
    
  public int longestCommonSubsequence(String text1, String text2) {    
      if(text2.length() < text1.length()) return longestCommonSubsequence(text2, text1);
      int[] previous = new int[text1.length() + 1];
      for(int col = text2.length() - 1; col >= 0; col--){
          int[] current = new int[text1.length() + 1];
          for(int row = text1.length() - 1; row >= 0; row--){
              if(text1.charAt(row) == text2.charAt(col)) current[row] = previous[row+1] + 1;
              else current[row] = Math.max(previous[row], current[row + 1]);
          }
          previous = current;
      }
      return previous[0];
  }    
}