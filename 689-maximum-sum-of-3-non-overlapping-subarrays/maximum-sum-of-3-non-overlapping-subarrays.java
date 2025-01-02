class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //1. Keep Track of indices for best single, double, triple subarrays
        int bestSingleStart = 0;
        int[] bestDoubleStart = new int[]{0, k};
        int[] bestTripleStart = new int[]{0, k, 2 * k};

        //2. First K
        int currSingleSum = 0, currDoubleSum = 0, currTripleSum = 0;
        for(int singleInd = 0; singleInd < k; singleInd++) {
            int doubleInd = singleInd + k, tripleInd = doubleInd + k;
            currSingleSum+= nums[singleInd];
            currDoubleSum+= nums[doubleInd];
            currTripleSum+= nums[tripleInd];
        }

        //3. Keep track of best seen
        int bestSingleSum = currSingleSum, bestDoubleSum = bestSingleSum + currDoubleSum, bestTripleSum = bestDoubleSum + currTripleSum;

        //4. Sliding window
        for(int right = k; right + 2 * k < nums.length; right++) {
            int singleRight = right, doubleRight = singleRight + k, tripleRight = doubleRight + k;
            int singleLeft = singleRight - k, doubleLeft = doubleRight - k, tripleLeft = tripleRight - k;
            //5. Advance sliding window
            currSingleSum = currSingleSum - nums[singleLeft++] + nums[singleRight];
            currDoubleSum = currDoubleSum - nums[doubleLeft++] + nums[doubleRight];
            currTripleSum = currTripleSum - nums[tripleLeft++] + nums[tripleRight];

            //6. Compare to best windows
            if(currSingleSum > bestSingleSum) {
                bestSingleSum = currSingleSum;
                bestSingleStart = singleLeft;
            }
            if(bestSingleSum + currDoubleSum > bestDoubleSum) {
                bestDoubleSum = bestSingleSum + currDoubleSum;
                bestDoubleStart = new int[]{bestSingleStart, doubleLeft};
            }
            if(bestDoubleSum + currTripleSum > bestTripleSum) {
                bestTripleSum = bestDoubleSum + currTripleSum;
                bestTripleStart = new int[]{bestDoubleStart[0], bestDoubleStart[1], tripleLeft};
            }
        }
        return bestTripleStart;
    }
}