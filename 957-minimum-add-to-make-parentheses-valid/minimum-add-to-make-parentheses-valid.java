class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0, leftCount = 0;
        for(Character c : s.toCharArray()){
            if(c == '(') leftCount++;
            else if(c == ')'){
                if(leftCount <= 0) count++;
                else leftCount--;
            }
        }
        return count + leftCount;
    }
}