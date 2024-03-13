class Solution {
    public int pivotInteger(int n) {
        int[] left = new int[n + 1], right = new int[n + 1];
        for(int i = 1; i <= n; i++) left[i] = i + left[i - 1];

        right[n] = n;
        for(int i = n - 1; i >= 1; i--) right[i] = i + right[i + 1];

        for(int i = 1; i <= n; i++) if(left[i] == right[i]) return i;
        return -1;
    }
}