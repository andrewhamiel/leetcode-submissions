class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int currNum = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            result.add(currNum);

            // If multiplying the current number by 10 is within the limit, do it
            if (currNum * 10 <= n) currNum *= 10;
            else {
                // Adjust the current number by moving up one digit
                while (currNum % 10 == 9 || currNum >= n) {
                    currNum /= 10; // Remove the last digit
                }
                currNum++; // Increment the number
            }
        }

        return result;
    }
}