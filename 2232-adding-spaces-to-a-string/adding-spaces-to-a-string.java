class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for(int i = 0; i < s.length(); i++){
            if(ind < spaces.length && i == spaces[ind]){
                sb.append(" ");
                ind++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}