class Solution {
    public int minMovesToMakePalindrome(String s) {
        if(s.length() == 0) return -1;

        char[] chars = s.toCharArray();             
        int swaps = 0;                              // int to store final number of swaps taken to make the palindrome
        int left = 0, right = s.length() - 1;

        while (left < right){
            // Found a palindrome
            if (chars[left] == chars[right]){
                left++;                             
                right--;                           
            }
            // Characters are not palindrome
            else{
                // Search for character moving towards the starting point 'left' to ensure
                // minimum number of moves until char at k matches char at 'left'
                int k = findIndexMatchingLeftIndex(chars, left, right);

                // Character matching char at index 'left' was not found between initial k index and left index
                if (k == left){
                    swaps++;                        
                    swapChars(chars, left);         
                }
                // Character matching char at index 'left' was found between initial k index and left index
                // Swap all characters from k to k + 1
                else{
                    while (k < right){
                        swaps++;
                        swapChars(chars, k);
                        k++;
                    }
                }
            }
        }
        return swaps;
    }

    /**
     * Swap Characters In The Character Array.
     */
    public void swapChars(char[] chars, int left) {
        // Swap chars[]
        if (left -1 < chars.length){
            char temp = chars[left];
            chars[left] = chars[left + 1];
            chars[left + 1] = temp;
        }
    }

    /**
     * Finds The Kth Index In The Input char[] That Matches The Character At The Left Index Of The Input char[].
     */
    public int findIndexMatchingLeftIndex(char[] chars, int left, int k) {
        while (left < k){
            if (chars[k] == chars[left]) return k;
            k--;                                    // Decrement k to compare with the previous index of the arr with left
        }
        return k;
    }
}