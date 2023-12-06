class Solution {
    public int totalMoney(int n) {
        int first = 1, count = 0, curr = 1;
        for(int i = 1; i <= n; i++){
            count+= curr;
            curr++;
            if(i % 7 == 0){
                first++;
                curr = first;
            }
        }
        return count;
    }
}