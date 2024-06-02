class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i =0;
        while(i < words.length){
            List<String> currLine = getWords(i, words, maxWidth);
            i+= currLine.size();
            ans.add(createLine(currLine, i, words, maxWidth));
        }
        return ans;
    }

    private List<String> getWords(int i, String[] words, int maxWidth){
        List<String> currLine = new ArrayList<>();
        int currLength = 0;

        while(i < words.length && currLength + words[i].length() <= maxWidth){
            currLine.add(words[i]);
            currLength+= words[i].length() + 1; //space
            i++;
        }
        return currLine;
    }

    private String createLine(List<String> currLine, int i, String[] words, int maxWidth){
        int baseLength = -1;
        for(String word : currLine){
            baseLength += word.length() + 1; //space
        }

        int extraSpaces = maxWidth - baseLength;
        if(currLine.size() == 1 || i == words.length){
            return String.join(" ", currLine) + " ".repeat(extraSpaces);
        }

        int wordCount = currLine.size() - 1;
        int spacesPerWord = extraSpaces/wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for(int j = 0; j < needsExtraSpace; j++){
            currLine.set(j, currLine.get(j) + " ");
        }

        for(int j = 0; j < wordCount; j++){
            currLine.set(j, currLine.get(j) + " ".repeat(spacesPerWord));
        }

        

        return String.join(" ", currLine);
    }
}