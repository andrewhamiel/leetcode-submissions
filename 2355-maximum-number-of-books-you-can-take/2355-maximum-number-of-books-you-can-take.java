class Solution {
    //https://leetcode.com/problems/maximum-number-of-books-you-can-take/discuss/2358714/Java-or-Stack-%2B-DP-or-Find-That-Bottleneck-or-Explanations-and-Proof-or-Comments-while-I-was-coding
    public long maximumBooks(int[] books) {
        long[] dp = new long[books.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < books.length; i++){
            while(!stack.isEmpty() && books[i] < books[stack.peek()]+i-stack.peek()){
                stack.pop();
            }
            int j = stack.isEmpty()? Math.max(0, i-books[i]+1) : stack.peek()+1;
            dp[i] = 1L*(books[i]+books[i]-(i-j))*(i-j+1)/2 + (stack.isEmpty()? 0 : dp[j-1]);
            stack.push(i);
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}