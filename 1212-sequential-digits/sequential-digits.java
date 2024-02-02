class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList<>();

        int lowLength = String.valueOf(low).length(), highLength = String.valueOf(high).length();
        for(int length = lowLength; length <= highLength; length++){
            for(int i = 0; i < n - length; i++){
                int num = Integer.parseInt(sample.substring(i, i + length));
                if(num >= low && num <= high) nums.add(num);
                else if(num > high) break;
            }
        }
        return nums;
    }
}