class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;

        int reversedNum = 0;
        while(reversedNum < x) {
            reversedNum*= 10;
            reversedNum+= (x % 10);
            x/= 10;
        }
        //Even length same, odd length remove a digit
        return reversedNum == x || reversedNum / 10 == x;
    }
}