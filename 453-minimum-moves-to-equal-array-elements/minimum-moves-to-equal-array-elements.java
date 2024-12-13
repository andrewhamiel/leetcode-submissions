class Solution {
    public int minMoves(int[] nums) {
        int minMove = Integer.MAX_VALUE, moves = 0;
        for(int num : nums) {
            minMove = Math.min(minMove, num);
            moves+= num;
        }
        return moves - nums.length * minMove;
    }
}