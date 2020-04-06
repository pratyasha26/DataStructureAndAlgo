package com.company.programmingBook;

public class AlienL {

    public static void  main(String args[]) {
        String words[] = {"abc",
                "bca",
                "dac",
                "dbc",
                "cba"};
        String pattern = "(ab) (bc) (ca)";
        for (int j = 0; j < words.length; j++) {
            char[] wordCharArray = words[j].toCharArray();
            String[] sPattern = pattern.split(" ");
            int count = 0;
            for (int i = 0; i < words[j].length(); i++) {
                char c = wordCharArray[i];
                int index = sPattern[i].indexOf(c);
                if (index != -1) {
                    count++;
                    continue;
                } else {
                    count = 0;
                    break;
                }
            }
            System.out.println(words[j]+ ": "+count);
        }
    }
}
