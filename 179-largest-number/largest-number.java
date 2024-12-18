class Solution {
    public String largestNumber(int[] nums) {
        //1. Convert nums to strings
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        //2. Sort in descending order
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        //3. Concatenate into single string
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }

        //4. Catch case of largest digit being '0'
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}