class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        // Variables to track the best indices for one, two, and three subarray configurations
        int bestSingleStart = 0;
        int[] bestDoubleStart = { 0, k };
        int[] bestTripleStart = { 0, k, k * 2 };

        // Compute the initial sums for the first three subarrays
        int singleCurrSum = 0, doubleCurrSum = 0, tripleCurrSum = 0;
        for (int i = 0; i < k; i++) {
            int secondInd = i + k;
            int thirdInd = i + 2 * k;
            singleCurrSum += nums[i];           
            doubleCurrSum+= nums[secondInd];
            tripleCurrSum+= nums[thirdInd];
        }

        // Track the best sums found so far
        int bestSingleSum = singleCurrSum;
        int bestDoubleSum = singleCurrSum + doubleCurrSum;
        int bestTripleSum = singleCurrSum + doubleCurrSum + tripleCurrSum;
        

        int singleLeft = 1;
        int doubleStartInd = k + 1;
        int tripleStartInd = k * 2 + 1;
        // Slide the windows across the array
        while (tripleStartInd <= nums.length - k) {
            // Update the sums using the sliding window technique
            singleCurrSum = singleCurrSum - nums[singleLeft - 1] + nums[singleLeft + k - 1];
            doubleCurrSum = doubleCurrSum - nums[doubleStartInd - 1] + nums[doubleStartInd + k - 1];
            tripleCurrSum = tripleCurrSum - nums[tripleStartInd - 1] + nums[tripleStartInd + k - 1];

            // Update the best single subarray start index if a better sum is found
            if (singleCurrSum > bestSingleSum) {
                bestSingleStart = singleLeft;
                bestSingleSum = singleCurrSum;
            }

            // Update the best double subarray start indices if a better sum is found
            if (doubleCurrSum + bestSingleSum > bestDoubleSum) {
                bestDoubleStart[0] = bestSingleStart;
                bestDoubleStart[1] = doubleStartInd;
                bestDoubleSum = doubleCurrSum + bestSingleSum;
            }

            // Update the best triple subarray start indices if a better sum is found
            if (tripleCurrSum + bestDoubleSum > bestTripleSum) {
                bestTripleStart[0] = bestDoubleStart[0];
                bestTripleStart[1] = bestDoubleStart[1];
                bestTripleStart[2] = tripleStartInd;
                bestTripleSum = tripleCurrSum + bestDoubleSum;
            }

            // Move the sliding windows forward
            singleLeft++;
            doubleStartInd++;
            tripleStartInd++;
        }

        return bestTripleStart;
    }
}