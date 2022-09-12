class Solution {
    
    public int minSwaps(String s) {
        int[] counts = getCount(s);
        int diff = Math.abs(counts[0]-counts[1]);
        if(diff>=2) return -1;
        if(counts[1]>counts[0]){
            String alt = createAltString(counts,true);
            return minhelper(s,alt);
        }else if(counts[0]>counts[1]){
            String alt = createAltString(counts,false);
            return minhelper(s,alt);
        }else return Math.min(minhelper(s,createAltString(counts,true)),minhelper(s,createAltString(counts,false)));
    }
    private int[] getCount(String s){
        int[] arr = new int[2];
        for(char ch:s.toCharArray()){
            arr[(ch-'0')]++;
        }   
        return arr;
    }
    
    private String createAltString(int[] counts,boolean isOne){
        int len = counts[0]+counts[1], prev = 1;
        StringBuilder sb = new StringBuilder();
        if(isOne) prev = 0;
        for(int i = 0;i<len;i++) {
            int val = Math.abs(prev-1);
            sb.append(val);
            prev = (val==0?0:1);
        }
        return sb.toString();    
    }
    
    private int minhelper(String s,String alt){
        int co = 0, cz = 0,min = 0, len = s.length();
        for(int i = 0;i<len;i++) {
            char ch1 = s.charAt(i),ch2 = alt.charAt(i);
            if(ch1!=ch2) {
                if(ch2=='1') {
                    if(co>0) co--;
                    else {
                        min++;
                        cz++;
                    }
                }
                else {
                    if(cz>0) cz--;
                    else{
                        min++;
                        co++;
                    }
                }
            }
        }
        return min;
    }   
}