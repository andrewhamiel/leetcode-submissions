class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0, leftCount = 0;
        for(char c : s.toCharArray()){
            if(c == '(') leftCount++;
            else if(c == ')'){
                if(leftCount > 0) leftCount--;
                else result++;
            }
        }
        return result + leftCount;
    }
}