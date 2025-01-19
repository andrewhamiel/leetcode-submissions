class Solution {
    /*
  Dutch National Flag problem solution.
  */
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
            //1. Red
            //2. White
            //3. Blue
            if (nums[white] == 0) swap(red++, white++, nums);
            else if (nums[white] == 1) white++;
            else swap(white, blue--, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}