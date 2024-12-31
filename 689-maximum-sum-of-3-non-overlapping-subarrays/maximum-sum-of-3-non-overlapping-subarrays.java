class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //1. Keep track of best indeces for single, double, triple subarrays
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

        //3. Store best found so far
        int bestSingleSum = currSingleSum, bestDoubleSum = bestSingleSum + currDoubleSum, bestTripleSum = bestDoubleSum + currTripleSum;
        
        //4. Sliding window
        for(int right = k; right + 2 * k < nums.length; right++) {
            int singleRight = right, doubleRight = singleRight + k, tripleRight = doubleRight + k;
            int singleLeft = singleRight - k, doubleLeft = doubleRight - k, tripleLeft = tripleRight - k;
            //5. Advance Sliding Window
            currSingleSum = currSingleSum - nums[singleLeft++] + nums[singleRight];
            currDoubleSum = currDoubleSum - nums[doubleLeft++] + nums[doubleRight];
            currTripleSum = currTripleSum - nums[tripleLeft++] + nums[tripleRight];

            //6. See if new windows now best
            if(currSingleSum > bestSingleSum) {
                bestSingleSum = currSingleSum;
                bestSingleStart = singleLeft;
            }

            if(currDoubleSum + bestSingleSum > bestDoubleSum) {
                bestDoubleSum = currDoubleSum + bestSingleSum;
                bestDoubleStart = new int[]{bestSingleStart, doubleLeft};
            }

            if(currTripleSum + bestDoubleSum > bestTripleSum) {
                bestTripleSum = currTripleSum + bestDoubleSum;
                bestTripleStart = new int[]{bestDoubleStart[0], bestDoubleStart[1], tripleLeft};
            }
        }
        return bestTripleStart;
    }
}