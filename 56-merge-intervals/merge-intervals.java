class Solution {
    public int[][] merge(int[][] intervals) {
		IntervalNode root=new IntervalNode(intervals[0][0], intervals[0][1]);
		
		for(int i=1;i<intervals.length;i++) {
			add(root, intervals[i]);
		}
		
		List<int[]> list=merge(root);
		int[][] ans=new int[list.size()][2];
		for(int i=0;i<ans.length;i++) {
			ans[i]=list.get(i);
		}
		return ans;
	}

    class IntervalNode{
		int low,high,max;
		IntervalNode left,right;
		IntervalNode(int l,int h){
			this.low=l;this.high=h;this.max=h;
			this.left=this.right=null;
		}
	}
	
	private List<int[]> merge(IntervalNode root){
		List<int[]> res=new ArrayList<>();
		if(root==null) return res;
		
		List<int[]> left=merge(root.left);
		List<int[]> right=merge(root.right);
		
		boolean inserted=false;
		for(int[] i:left) {
			if(i[1]>=root.low) {
				inserted=true;
				i[0]=Math.min(i[0], root.low);
				i[1]=Math.max(i[1], root.high);
				root=new IntervalNode(i[0], i[1]);
			}
			res.add(i);
		}
		
		if(!inserted) res.add(new int[] {root.low,root.high});
		
		for(int[] i:right) {
			if(i[0]<=root.high) {
				inserted=true;
				i[0]=Math.min(i[0], root.low);
				i[1]=Math.max(i[1], root.high);
				res.remove(res.size()-1);
			}
			res.add(i);
		}
		
		return res;
		
	}
	
	private IntervalNode add(IntervalNode root,int[] i) {
		if(root==null) return new IntervalNode(i[0], i[1]);
		
		if(i[0]<root.low)
			root.left=add(root.left, i);
		else
			root.right=add(root.right,i);
		return root;
	}
}