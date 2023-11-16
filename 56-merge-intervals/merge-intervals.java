class Solution {
    public int[][] merge(int[][] intervals) {
        IntervalNode root = new IntervalNode(intervals[0][0], intervals[0][1]);

				//1. Add
				for(int[] interval : intervals) add(root, interval);

				//2. Merge
				List<int[]> list = merge(root);

				//3. Build result
				int[][] result = new int[list.size()][2];
				for(int i = 0; i < result.length; i++) result[i] = list.get(i);
				return result;
    }

		private List<int[]> merge(IntervalNode root){
			if(root == null) return new ArrayList<>();
			List<int[]> result = new ArrayList<>();

			List<int[]> left = merge(root.left);
			List<int[]> right = merge(root.right);

			boolean isInserted = false;
			for(int[] interval : left){
				if(interval[1] >= root.low){
					isInserted = true;
					interval[0] = Math.min(interval[0], root.low);
					interval[1] = Math.max(interval[1], root.high);
					root = new IntervalNode(interval[0], interval[1]);
				}
				result.add(interval);
			}

			if(!isInserted) result.add(new int[]{root.low, root.high});

			for(int[] interval : right){
				if(interval[0] <= root.high){
					interval[0] = Math.min(interval[0], root.low);
					interval[1] = Math.max(interval[1], root.high);
					result.remove(result.size() - 1);
				}
				result.add(interval);
			}
			return result;
		}

		private IntervalNode add(IntervalNode root, int[] interval){
			if(root == null) return new IntervalNode(interval[0], interval[1]);

			if(interval[0] < root.low) root.left = add(root.left, interval);
			else root.right = add(root.right, interval);
			return root;
		}

		class IntervalNode {
			int low, high;
			IntervalNode left, right;

			public IntervalNode(int low, int high){
				this.low = low;
				this.high = high;
			}
		}
}