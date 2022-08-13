class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> sbList = new ArrayList();
        for(int i = 0; i < numRows; i++) 
            sbList.add(new StringBuilder());
        
        int col = 0, row = 0;
        boolean diag = false;
        for(int i = 0; i < s.length(); i++){
            sbList.get(row).append(s.charAt(i));
            if(!diag) {    
                if(row == numRows - 1){
                    diag = true;
                    row--;
                }else row++;
            }else{
                if(row == 0){
                    diag = false;
                    row++;
                }else row--;
            }
        }
        
        StringBuilder finalSb = new StringBuilder();
        for(StringBuilder sb : sbList)
            finalSb.append(sb.toString());
        return finalSb.toString();
    }
}