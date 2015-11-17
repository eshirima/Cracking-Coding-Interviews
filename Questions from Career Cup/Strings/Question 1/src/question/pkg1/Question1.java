/*
 * Time Complexity O(n squared)
 * Space Complexity O(1). I just created the arraylist of legal words to mimic
 * what the dictionary may contain
 */
package question.pkg1;

import java.util.ArrayList;

/**
 *
 * @author espunky
 */
public class Question1 {
    
    public static ArrayList<String> legalWords = new ArrayList<String>();
    
    public static void createDictionary()
    {
        legalWords.add("people");
        legalWords.add("awesome");
        legalWords.add("university");
    }
    
    public static String getLongestWord(String firstWord, String secondWord)
    {
        if(firstWord.length() > secondWord.length())
        {
            return firstWord;
        }
        else
        {
            return secondWord;
        }
    }
    public static boolean isWordLegal(String word)
    {
        for(int i = 0; i < legalWords.size(); ++i)
        {
            if(word.equals(legalWords.get(i)))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static String findLongestLegalWord(String passedWord)
    {
        char [] respectiveCharacters = passedWord.toCharArray();
        String longestWord = "";
        
        for(int i = 0; i < respectiveCharacters.length; ++i)
        {
            for(int j = i + 1; j < respectiveCharacters.length; ++j)
            {
                if(isWordLegal(passedWord.substring(i, j + 1)))
                {
                    longestWord = getLongestWord(longestWord, passedWord.substring(i, j + 1));
                }
            }
        }
        
        return longestWord;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        createDictionary();
        
        String answer0 = findLongestLegalWord("lhdjghgshg");
        String answer1 = findLongestLegalWord("people");
        String answer2 = findLongestLegalWord("unikdgjkggkjsversityawesome");
        String answer3 = findLongestLegalWord("peuniversityople");
        String answer4 = findLongestLegalWord("univjfbdjjgbdgjbdpeople");
        String answer5 = findLongestLegalWord("awesomepeople");
        String answer6 = findLongestLegalWord("universitypeople");
        String answer7 = findLongestLegalWord("awesomepeopleuniversity");
        String answer8 = findLongestLegalWord("awesomeuniversitypeople");
        
        System.out.println(answer0);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(answer5);
        System.out.println(answer6);
        System.out.println(answer7);
        System.out.println(answer8);
    }
    
}
