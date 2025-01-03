class SparseVector {
    private List<int[]> pairs = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(nums[i] != 0) pairs.add(new int[]{i, nums[i]});
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0, p = 0, q = 0;
        while(p < pairs.size() && q < vec.pairs.size()) {
            if(pairs.get(p)[0] == vec.pairs.get(q)[0]) dotProduct+= pairs.get(p++)[1] * vec.pairs.get(q++)[1];
            else if(pairs.get(p)[0] < vec.pairs.get(q)[0]) p++;
            else q++;
        }
        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);