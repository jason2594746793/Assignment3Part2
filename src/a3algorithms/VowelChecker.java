package a3algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelChecker {
    private VowelChecker() {} // 01/04/2023 updated to have private visibility, do not change

    /**
     * Done: isVowel() checks if a String is one of the five English vowels
     *  "y" is not considered a vowel here. Assume lowercase input.
     *
     * @param s
     * @return
     */
    public static boolean isVowel(String s){
        // create a set of vowels
        Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
        return vowels.contains(s);
    }
}
