class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        for(int i = 0; i < Math.min(v1.length, v2.length); i++){
            Integer first = Integer.parseInt(v1[i]), second = Integer.parseInt(v2[i]);
            if(first > second) return 1;
            else if(second > first) return -1;
        }
        if(v1.length > v2.length){
            for(int i = v2.length; i < v1.length; i++){
                Integer minorVersion = Integer.parseInt(v1[i]);
                if(minorVersion != 0) return 1;
            }
        }else if(v2.length > v1.length){
            for(int i = v1.length; i < v2.length; i++){
                Integer minorVersion = Integer.parseInt(v2[i]);
                if(minorVersion != 0) return -1;
            }
        }
        return 0;
        
    }
}