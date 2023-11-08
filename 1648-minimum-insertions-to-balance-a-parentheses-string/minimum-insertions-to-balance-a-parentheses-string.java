class Solution {
    public int minInsertions(String s) {
        int rightCount = 0, result = 0;
        for(Character c : s.toCharArray()){
            if(c == '('){
                if(rightCount % 2 > 0){
                    result++;
                    rightCount--;
                }
                rightCount+= 2;
            }else{
                rightCount--;
                if(rightCount < 0){
                    result++;
                    rightCount+= 2;
                }
            }
        }
        return rightCount + result;
    }
}