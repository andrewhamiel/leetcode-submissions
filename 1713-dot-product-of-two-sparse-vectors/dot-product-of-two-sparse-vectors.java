class SparseVector {
    Map<Integer, Integer> nonZeroes;
    
    SparseVector(int[] nums) {
        nonZeroes = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) nonZeroes.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        if(nonZeroes.size() > vec.nonZeroes.size()) return vec.dotProduct(this);
        for(Map.Entry<Integer, Integer> entry : nonZeroes.entrySet()){
            if(vec.nonZeroes.containsKey(entry.getKey())) product+= entry.getValue() * vec.nonZeroes.get(entry.getKey());
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);