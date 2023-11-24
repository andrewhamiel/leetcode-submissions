class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int ind = -1;
        for(char c : s.toCharArray()){
          if(ind >= 0 && sb.charAt(ind) == c){
            sb.deleteCharAt(ind--);
          }else{
            sb.append(c);
            ind++;
          }
        }
        return sb.toString();
    }
}