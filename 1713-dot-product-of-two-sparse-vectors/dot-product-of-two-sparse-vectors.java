class SparseVector {
    private List<int[]> pairs = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) pairs.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ptrA = 0, ptrB = 0, dotProduct = 0;
        while(ptrA < pairs.size() && ptrB < vec.pairs.size()) {
            int[] a = pairs.get(ptrA), b = vec.pairs.get(ptrB);
            if(a[0] == b[0]) {
                dotProduct+= a[1] * b[1];
                ptrA++;
                ptrB++;
            }else if(a[0] < b[0]) ptrA++;
            else ptrB++;
        }
        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);