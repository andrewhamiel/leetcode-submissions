class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int currNum = 1;

        for(int i = 0; i < n; i++) {
            result.add(currNum);
            if(currNum * 10 <= n) currNum*= 10;
            else {
                //Increment by 1
                while(currNum % 10 == 9 || currNum >= n) currNum/= 10;
                currNum++;
            }
        }
        return result;
    }
}