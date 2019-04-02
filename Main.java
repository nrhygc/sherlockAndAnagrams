package com.company;
import java.io.IOException;
import java.util.*;

public class Main {

    // Complete the sherlockAndAnagrams function below.
        static int sherlockAndAnagrams(String s) {

        ArrayList<String> twoCob= new ArrayList<>();

        int counter=0;
        for(int i=1;i<s.length();i++)
        {
            for(int j=0;j<(s.length()-i+1);j++)
            {
                String trial = s.substring(j,(j+i));

                for (String subs:twoCob) {
                    if(subs.length()!=trial.length())
                        continue;
                    if(trial.length()==1) {
                        if (trial.compareTo(subs) == 0) {
                            counter++;
                        }
                    }
                        else if(compAnagramString(subs,trial)) {
                        counter++;
                    }

                }

                twoCob.add(trial);
            }
        }
        return counter;
    }

    static boolean compAnagramString(String subs, String trial)
    {
        // Result hashset
        HashMap<Character,Integer> resultDict = new HashMap<>();
        char[] subCharArray=subs.toCharArray();

        char[] trialCharArray=trial.toCharArray();

        for (int i = 0; i < subCharArray.length; i++) {
            char cKey=subCharArray[i];
            if(resultDict.containsKey(cKey)==false)
            {
                resultDict.put(cKey,1);
            }
            else
            resultDict.put(cKey,resultDict.get(cKey)+1);
        }

        HashMap<Character,Integer> trialDict = new HashMap<>();

        for (int i = 0; i < trialCharArray.length; i++) {
            char cKey=trialCharArray[i];
            if(trialDict.containsKey(cKey)==false)
            {
                trialDict.put(cKey,1);
            }
            else
            trialDict.put(cKey,trialDict.get(cKey)+1);
        }

        for(Character key : resultDict.keySet())
        {
            if(!trialDict.containsKey(key)|| trialDict.get(key).compareTo(resultDict.get(key))!=0)
                return false;
        }
       return true;
    }

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        System.out.println(new Date());
        int result = sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel");
        System.out.println(result);

        result=sherlockAndAnagrams("gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde");
        System.out.println(result);
        System.out.println(new Date());
    }

}
