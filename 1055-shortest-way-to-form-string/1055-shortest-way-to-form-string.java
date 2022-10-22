class Solution {
    public int shortestWay(String source, String target) {
        int res = 1, sInd = 0, tInd = 0;
        Set<Character> seen = new HashSet();
        //add each source char
        for(Character c : source.toCharArray()) seen.add(c);
        //if unseen char in target, impossible string
        for(Character c : target.toCharArray()) 
            if(seen.add(c)) return -1;
        
        while(tInd != target.length()){
            //if we have iterated through each s char, reset
            if(sInd == source.length()){
                sInd = 0;
                res++;
            }
            //if characters equal, inc
            if(source.charAt(sInd) == target.charAt(tInd)){
                sInd++;
                tInd++;
            }
            //otherwise inc source
            else sInd++;
        }
        return res;
    }
}