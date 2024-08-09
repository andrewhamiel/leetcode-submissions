class Solution {
    public int[] separateDigits(int[] nums) {
        int digits = 0;
        for(int num : nums){
            if(num == 0){
                digits++;
                continue;
            }
            while(num > 0){
                num/= 10;
                digits++;
            }
        }
        int[] result = new int[digits];
        int i = result.length - 1;
        for(int j = nums.length - 1; j >= 0; j--){
            int num = nums[j];
            if(num == 0){
                result[i--] = num;
            }
            while(num != 0){
                result[i--] = num % 10;
                num/= 10;
            }
        }
        return result;
    }
}