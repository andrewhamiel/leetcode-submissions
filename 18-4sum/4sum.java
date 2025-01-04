class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(0, nums, target, 4);
    }

    private List<List<Integer>> kSum(int left, int[] nums, long target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        //1. Exit condition
        if(left == nums.length) return result;
        //2. Out of bounds sum. K nums left, if nums[left] > averageVal || nums[nums.length - 1] < averageVal then sum not possible
        long averageVal = target / k;
        if(nums[left] > averageVal || nums[nums.length - 1] < averageVal) return result;
        //3. Base case
        if(k == 2) return twoSumSorted(left, nums, target);
        //4. KSum
        for(int i = left; i < nums.length; i++) {
            if(i == left || nums[i] != nums[i - 1]) {
                for(List<Integer> subList : kSum(i + 1, nums, target - nums[i], k - 1)) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i]));
                    list.addAll(subList);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSumSorted(int left, int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[left++], nums[right--])));
                while(left < nums.length && nums[left] == nums[left - 1]) left++;
            }else if(sum < target) left++;
            else right--;
        }
        return result;
    }
}