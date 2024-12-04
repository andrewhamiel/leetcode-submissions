class Solution {
    public String largestNumber(int[] nums) {
        //1. Convert numbers to strings 
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        //2. Sort in descending order 
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        //3. Concatenate into single string
        StringBuilder result = new StringBuilder();
        for(String str : strs) result.append(str);

        //4. Handle largest digit being 0
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}