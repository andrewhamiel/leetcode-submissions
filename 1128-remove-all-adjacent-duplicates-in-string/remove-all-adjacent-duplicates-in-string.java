class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        int ind = -1;
        for(char c : s.toCharArray()){
          if(ind >= 0 && result.charAt(ind) == c) result.deleteCharAt(ind--);
          else{
            result.append(c);
            ind++;
          }
        }
        return result.toString();
    }
}