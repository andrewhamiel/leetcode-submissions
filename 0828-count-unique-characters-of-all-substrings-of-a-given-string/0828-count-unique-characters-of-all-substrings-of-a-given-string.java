class Solution {
    //Greedy. Time: O(n)
    //Space: O(n)
    public int uniqueLetterString(String s) {
        int[] left = new int[26], right = new int[s.length()];
        Arrays.fill(left, s.length());
        Arrays.fill(right, s.length());
        int ans = 0;
        //Update rightmost
        for(int i = s.length() - 1; i >= 0; i--){
            int curr = s.charAt(i) - 'A';
            right[i] = left[curr];
            left[curr] = i;
        }
        Arrays.fill(left, -1);
        //Compute ans
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'A';
            // A|-----x-----|A|----y----|A
            // Sum = x * y
            int sum = (i - left[curr]) * (right[i] - i);
            ans+=sum;
            left[curr] = i; //update leftmost
        }
        return ans;
    }
}