package com.company.programmingBook;

public class AlienL {

    public static void  main(String args[]) {

        String pattern[] = {"(ab) (bc) (ca)","abc",
                "(abc) (abc) (abc)",
                "(zyx) bc"};
        for(int p=0;p<pattern.length;p++) {

            System.out.println("pattern : "+pattern[p] +" :" +getAlienCount(pattern[p]));
        }
    }

    private static int getAlienCount(String pattern) {
        int globalCount=0;
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
                    count++;
                  //  System.out.println(words[j]+ ": "+count);
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

            }
          //  System.out.println(words[j]+ ": "+count);
            if(count!=0) {
                globalCount++;
            }
           count=0;
        }
        return globalCount;
    }
}
