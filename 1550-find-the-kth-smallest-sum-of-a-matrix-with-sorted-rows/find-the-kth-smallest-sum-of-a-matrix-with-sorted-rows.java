class Solution {
	public int kthSmallest(int[][] mat, int k) {
		int[] row = mat[0];

		for (int i = 1; i < mat.length; i++)
			row = kSmallestPairSums(row, mat[i], k);
		return row[k - 1];
	}

	private int[] kSmallestPairSums(int[] nums1, int[] nums2, int k) {
		List<Integer> list = new ArrayList<>();
		Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

		for (int i = 0; i < k && i < nums1.length; i++)
			minHeap.offer(new int[] {nums1[i], nums2[0], 0});

		for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
			int[] candidate = minHeap.poll();
			list.add(candidate[0] + candidate[1]);
            int nums2Idx = candidate[2];
			if (nums2Idx < nums2.length - 1)
				minHeap.offer(new int[] {candidate[0], nums2[nums2Idx + 1], nums2Idx + 1});
		}
        
		return list.stream().mapToInt(i -> i).toArray();
	}
}