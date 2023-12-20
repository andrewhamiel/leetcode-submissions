class Solution {
    public int buyChoco(int[] prices, int money) {
        int minFirst = Integer.MAX_VALUE, minSecond = Integer.MAX_VALUE;
        for(int price : prices){
            if(price <= minFirst){
                minSecond = minFirst;
                minFirst = price;
            }else if(price < minSecond) minSecond = price;
        }
        return minFirst + minSecond <= money ? money - minFirst - minSecond : money;
    }
}