class Solution {
    public String largestNumber(int[] nums) {
        //1. Convert each num to a string
        String[] numStrings = new String[nums.length];
        for(int i = 0; i < nums.length; i++) numStrings[i] = Integer.toString(nums[i]);

        //2. Sort array 
        Arrays.sort(numStrings, ((a, b) -> (b + a).compareTo(a + b)));

        //3. Convert to single string 
        StringBuilder result = new StringBuilder();
        for(String str : numStrings) result.append(str);

        //4. Handle case where largest digit is 0
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}