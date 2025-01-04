class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int left, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Exit Condition
        if (left == nums.length) return result;

        // 2. Nums out of range. There are k remaining values to add to the sum. Sum of target not possible if smallest val in nums > avg or if the largest val < avg
        long averageVal = target / k;
        if (nums[left] > averageVal || nums[nums.length - 1] < averageVal) return result;

        //3. Base case
        if (k == 2) return twoSum(nums, target, left);

        //4. KSum
        for (int i = left; i < nums.length; i++) {
            if (i == left || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int left) {
        List<List<Integer>> result = new ArrayList<>();
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result.add(Arrays.asList(nums[left++], nums[right--]));
                while(left < nums.length && nums[left] == nums[left - 1]) left++;
            }else if (sum < target) left++;
            else right--;           
        }
        return result;
    }
}