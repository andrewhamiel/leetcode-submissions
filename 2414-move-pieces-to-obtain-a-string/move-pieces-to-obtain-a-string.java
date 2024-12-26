class Solution {
    public boolean canChange(String start, String target) {
        int startInd = 0, targetInd = 0;
        while(startInd < start.length() || targetInd < target.length()) {
            //Advance underscores
            while(startInd < start.length() && start.charAt(startInd) == '_') startInd++;
            while(targetInd < target.length() && target.charAt(targetInd) == '_') targetInd++;

            //Exit conditions
            if(startInd == start.length() || targetInd == target.length()) return startInd == start.length() && targetInd == target.length();
            if(start.charAt(startInd) != target.charAt(targetInd) 
                || (start.charAt(startInd) == 'L' && startInd < targetInd)
                || (start.charAt(startInd) == 'R' && startInd > targetInd)) return false;
            
            startInd++;
            targetInd++;
        }
        return true;
    }
}