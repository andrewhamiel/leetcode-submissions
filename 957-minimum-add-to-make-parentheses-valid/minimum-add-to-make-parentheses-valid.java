class Solution {
    public int minAddToMakeValid(String s) {
        int leftCount = 0, toAdd = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') leftCount++;
            else if(c == ')') {
                if(leftCount > 0) leftCount--;
                else toAdd++;
            }
        }
        toAdd+= leftCount;
        return toAdd;
    }
}