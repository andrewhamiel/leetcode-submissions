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
        

        for(int right = k; right + 2 * k < nums.length; right++) {
            int singleRight = right, doubleRight = right + k, tripleRight = right + 2 * k;
            int singleLeft = singleRight - k, doubleLeft = doubleRight - k, tripleLeft = tripleRight - k;
            // Update the sums using the sliding window technique
            singleCurrSum = singleCurrSum - nums[singleLeft++] + nums[singleRight];
            doubleCurrSum = doubleCurrSum - nums[doubleLeft++] + nums[doubleRight];
            tripleCurrSum = tripleCurrSum - nums[tripleLeft++] + nums[tripleRight];

            // Update the best single subarray start index if a better sum is found
            if (singleCurrSum > bestSingleSum) {
                bestSingleStart = singleLeft;
                bestSingleSum = singleCurrSum;
            }

            // Update the best double subarray start indices if a better sum is found
            if (doubleCurrSum + bestSingleSum > bestDoubleSum) {
                bestDoubleStart[0] = bestSingleStart;
                bestDoubleStart[1] = doubleLeft;
                bestDoubleSum = doubleCurrSum + bestSingleSum;
            }

            // Update the best triple subarray start indices if a better sum is found
            if (tripleCurrSum + bestDoubleSum > bestTripleSum) {
                bestTripleStart[0] = bestDoubleStart[0];
                bestTripleStart[1] = bestDoubleStart[1];
                bestTripleStart[2] = tripleLeft;
                bestTripleSum = tripleCurrSum + bestDoubleSum;
            }
        }

        return bestTripleStart;
    }
}