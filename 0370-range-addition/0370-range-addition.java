class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(updates.length == 0) return new int[length];
        int[] results = new int[length];
        for(int[] update : updates){
            int startInd = update[0], endInd = update[1], increment = update[2];
            results[startInd]+=increment;
            if(endInd + 1 < length) results[endInd + 1]-=increment;
        }
        
        for(int i = 1; i < length; i++)
            results[i]+= results[i-1];
        return results;
    }
}