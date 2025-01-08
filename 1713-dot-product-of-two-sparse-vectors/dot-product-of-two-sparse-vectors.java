class SparseVector {
    private List<int[]> pairs = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) pairs.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int aPtr = 0, bPtr = 0, dotProduct = 0;
        while(aPtr < pairs.size() && bPtr < vec.pairs.size()) {
            int[] pairA = pairs.get(aPtr), pairB = vec.pairs.get(bPtr);
            if(pairA[0] == pairB[0]) {
                dotProduct+= (pairA[1] * pairB[1]);
                aPtr++;
                bPtr++;
            }else if(pairA[0] < pairB[0]) aPtr++;
            else bPtr++;
        }
        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);