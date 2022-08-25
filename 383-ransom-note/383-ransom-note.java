class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArr = new char[26], magArr = new char[26];
        for(int i = 0; i < ransomNote.length(); i++) ransomArr[ransomNote.charAt(i) - 'a']++;
        for(int i = 0; i < magazine.length(); i++) magArr[magazine.charAt(i) - 'a']++;
        
        for(int i = 0; i < 26; i++){
            if(ransomArr[i] > magArr[i]) return false;
        }
        return true;
    }
}