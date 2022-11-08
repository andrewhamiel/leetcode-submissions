class Solution {
    public int uniqueLetterString(String s) {
        int[] right = new int[s.length()], left = new int[26];
        Arrays.fill(right, s.length());
        Arrays.fill(left, s.length());
        int ans = 0;
        //update rightmost
        for(int i = s.length() - 1; i >= 0; i--){
            int curr = s.charAt(i) - 'A';
            right[i] = left[curr];
            left[curr] = i;
        }
        Arrays.fill(left, -1);
        //Compute sum
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'A';
            //sum = x * y
            //A|----x----|A |----y----|A
            int sum = (i - left[curr]) * (right[i] - i);
            ans+=sum;
            left[curr] = i; //update left
        }
        return ans;
    }
}