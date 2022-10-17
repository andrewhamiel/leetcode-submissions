class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] unseen = new int[26];
        Arrays.fill(unseen, -1);
        
        for(Character c : sentence.toCharArray()) unseen[c - 'a']++;
        for(int letter : unseen) if(letter < 0)return false;
        return true;
    }
}