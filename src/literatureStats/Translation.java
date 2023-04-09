package literatureStats;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Code to translate words according to the language is directly inside this enum.
 */
public enum Translation {
    NONE {
        @Override
        public String translate(String word) {
            return word;
        }
    },

    // Done: put the code for translating troll directly inside the overriden method
    TROLL {
        @Override
        public String translate(String word) {
            word = "grunt";
            return word;
        }
    },

    /* DONE: translate into British doggie speak. Dogs from different countries
        speak different doggie languages. British dogs speak like this:
        1. Move the first non-vowel cluster to the end of the word.
            This is everything up to but not including the first vowel.
        2. Append "ay" to the word unless:
           2.1 the word originally began with "b" in which case it ends "bark"
               before -> eforebark, but -> utbark
           2.2 the word originally began with "g" in which case it ends "grrrowl"
               with 3 rs but the "g" is the one that was originally at the start
               of the word:
               good	->	oodgrrrowl, great -> eatgrrrrowl, gutenberg -> utenberggrrrowl
           2.3 the word originally began with "r" in which case it ends "rrruf"
               with 3 rs but the first of those is the "r" that was originally
               at the start of the word:
               ross	->	ossrrruf, room	->	oomrrruf
           2.4 the word originally began with "w" in which case
               2.4.1 it ends "woof" with the "w" being the one that was
                     originally at the start of the word
                     was -> aswoof, who -> owhwoof
               2.4.2 unless the word orginally began "wo" in which case it ends
                     "woofWoof" (note the one capital W) where the first "w" is
                     the one that was originally at the start of the word:
                     work -> orkwoofWoof, would -> ouldwoofWoof
        Other examples:
          3 -> 3ay, a -> aay, ay -> ayay, ebook -> ebookay, under -> underay
          An empty word is completely unchanged.
     */
    DOG {
        @Override
        public String translate(String word) {
            String result = "";
            Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
            String nonVowelCluster = "";
            //loop over the word to get the nonVowelCluster
            if (word == null || word.isEmpty()) {
                return "";
            } else {
                for (int i = 0; i < word.length(); i++) {
                    char currentChar = word.charAt(i);

                    if (!vowels.contains(String.valueOf(Character.toLowerCase(currentChar)))) {
                        nonVowelCluster += currentChar;
                    } else {
                        break;
                    }
                }
                //if the word starts with b, g, r, or w, do the special cases
                char firstChar = word.charAt(0);
                switch (Character.toLowerCase(firstChar)) {
                    case 'b':
                        result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "bark";
                        break;
                    case 'g':
                        result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "rrrowl";
                        break;
                    case 'r':
                        result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "rruf";
                        break;
                    case 'w':
                        if (word.length() >= 2 && Character.toLowerCase(word.charAt(1)) == 'o') {
                            result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "oofWoof";
                        } else {
                            result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "oof";
                        }
                        break;
                    default:
                        result = word.substring(nonVowelCluster.length()) + nonVowelCluster + "ay";
                }
                return result;
            }

        }
    };

    /**
     * DONE: Translates the word component of a {@link FrequencyWord}.
     *
     * @param frequencyWord
     * @return
     */
    public String translate(FrequencyWord frequencyWord) {
        return translate(frequencyWord.normalised);
    }

    /**
     * The base pattern for translating. DO NOT CHANGE THIS IN ANY WAY.
     *
     * @param word
     * @return
     */
    public abstract String translate(String word);

}
