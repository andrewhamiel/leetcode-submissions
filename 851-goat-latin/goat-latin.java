class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\s");
        for(int wordInd = 0; wordInd < words.length; wordInd++) {
            String word = words[wordInd];
            if(!word.isEmpty()) {
                char first = word.charAt(0);
                if(vowels.contains(first)) {
                    result.append(word);
                }else {
                    //Consonant
                    for(int i = 1; i < word.length(); i++) {
                        result.append(word.charAt(i));
                    }
                    result.append(first);
                }
                result.append("ma");
                for(int i = 0; i <= wordInd; i++) result.append('a');
            }
            if(wordInd != words.length - 1) result.append(" ");
        }
        return result.toString();
    }
}