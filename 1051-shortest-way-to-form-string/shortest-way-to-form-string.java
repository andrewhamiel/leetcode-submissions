class Solution {
    public int shortestWay(String source, String target) {
        //2 pointer 
        int targetInd = 0, count = 0;
        while(targetInd < target.length()){
            boolean foundChar = false;
            for(int i = 0; i < source.length() && targetInd < target.length(); i++){
                if(source.charAt(i) == target.charAt(targetInd)){
                    foundChar = true;
                    targetInd++;
                }
            }
            if(!foundChar) return -1;
            count++;
        }
        return count;
    }
}