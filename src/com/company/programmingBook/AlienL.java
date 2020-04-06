package com.company.programmingBook;

public class AlienL {

    public static void  main(String args[]) {

        String pattern[] = {"(ab) (bc) (ca)","abc",
                "(abc) (abc) (abc)",
                "(zyx) bc"};
        for(int p=0;p<pattern.length;p++) {
            System.out.println("pattern : " +(p+1));
            getAlienCount(pattern[p]);
        }
    }

    private static void getAlienCount( String pattern) {
        String words[] = {"abc",
                "bca",
                "dac",
                "dbc",
                "cba"};
        int count = 0;
        for (int j = 0; j < words.length; j++) {
            char[] wordCharArray = words[j].toCharArray();
            if(!pattern.contains(" ")) {
                if(words[j].equals(pattern)){
                    count= pattern.length();
                    System.out.println(words[j]+ ": "+count);
                }
            }
            else {
                String[] sPattern = pattern.split(" ");

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
           count=0;
        }
    }
}
