package com.company.programmingBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienL {

    private static List<String> extractTokens(String pattern) {
        final List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == '(') {
                int startPosition = i + 1;
                int tokenEnd = pattern.substring(startPosition).indexOf(')') + startPosition;
                tokens.add(pattern.substring(startPosition, tokenEnd));
                i = tokenEnd + 1;
            } else {
                tokens.add(Character.toString(pattern.charAt(i)));
                i++;
            }
        }
        return tokens;
    }

    private static LanguageDataset readDataset(String filePath) throws IOException {
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String st;
            st = br.readLine();
            int[] datasetDescription = Arrays.stream(st.split(" ")).mapToInt(Integer::parseInt).toArray();
            int wordLength = datasetDescription[0]; // L
            int totalWordsInLanguage = datasetDescription[1]; // D
            int totalTestPatterns = datasetDescription[2]; // M
            List<String> languageWords = new ArrayList<>();
            List<String> testPatterns = new ArrayList<>();

            while (totalWordsInLanguage != 0) {
                st = br.readLine();
                languageWords.add(st);
                totalWordsInLanguage--;
            }
            while (totalTestPatterns != 0) {
                st = br.readLine();
                testPatterns.add(st);
                totalTestPatterns--;
            }
            return new LanguageDataset(wordLength, languageWords, testPatterns);
        }
    }

    public static void main(String args[]) throws IOException {

        LanguageDataset dataset = AlienL.readDataset("Alien_Language_Dataset" + File.separator + "A-small-practice.in");
        List<String> testPatterns = dataset.getTestPatterns();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Alien_Language_Dataset" + File.separator + "A-small-practice.out"))) {
            for (int p = 0; p < testPatterns.size(); p++) {
                bw.write("Case #" + (p + 1) + ": " + getAlienCount(testPatterns.get(p), dataset) + System.getProperty("line.separator"));
            }
        }
    }

    private static int getAlienCount(String pattern, LanguageDataset dataset) {
        int globalCount = 0;
        List<String> words = dataset.getWordsInLanguage();
        int count = 0;
        for (int j = 0; j < words.size(); j++) {
            char[] wordCharArray = words.get(j).toCharArray();
            if (!pattern.contains("(")) {
                if (words.get(j).equals(pattern)) {
                    count++;
                }
            } else {
                List<String> tokenList = AlienL.extractTokens(pattern);

                for (int i = 0; i < words.get(j).length(); i++) {
                    char c = wordCharArray[i];
                    int index = tokenList.get(i).indexOf(c);
                    if (index != -1) {
                        count++;
                        continue;
                    } else {
                        count = 0;
                        break;
                    }
                }

            }
            if (count != 0) {
                globalCount++;
            }
            count = 0;
        }
        return globalCount;
    }
}