class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 0, nonUnique = 0;
        while(nonUnique < nums.length) {
            if(nonUnique < nums.length - 1 && nums[nonUnique] == nums[nonUnique + 1]) {
                //first element 
                swap(unique++, nonUnique++, nums);
                //find second element
                while(nonUnique < nums.length - 1 && nums[nonUnique] == nums[nonUnique + 1]) nonUnique++;
            }
            swap(unique++, nonUnique++, nums);
        }
        return unique;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}