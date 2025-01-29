class Solution {
    public int maxScore(String s) {
        int ones = 0, zeroes = 0, best = Integer.MIN_VALUE;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '1') ones++;
            else zeroes++;

            best = Math.max(best, zeroes - ones);
        }

        if(s.charAt(s.length() - 1) == '1') ones++;

        return best + ones;
    }
}