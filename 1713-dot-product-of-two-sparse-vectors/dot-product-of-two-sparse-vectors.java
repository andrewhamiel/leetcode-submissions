class SparseVector {
    Map<Integer, Integer> map = new HashMap<>();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(nums[i] != 0) map.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        for(int key : vec.map.keySet()) {
            if(map.containsKey(key)) product+= (vec.map.get(key) * map.get(key)); 
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);