package com.varunsharma;

import java.util.List;

public class LanguageDataset {
    private final List<String> wordsInLanguage;
    private final List<String> testPatterns;
    private final int wordLength;

    LanguageDataset(int wordLength, List<String> wordsInLanguage, List<String> testPatterns) {
        this.wordsInLanguage = wordsInLanguage;
        this.testPatterns = testPatterns;
        this.wordLength = wordLength;
    }

    public List<String> getWordsInLanguage() {
        return wordsInLanguage;
    }

    public List<String> getTestPatterns() {
        return testPatterns;
    }

    public int getWordLength() {
        return wordLength;
    }
}
