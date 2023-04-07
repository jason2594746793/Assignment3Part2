package a3algorithms;

public class Normaliser {
    private Normaliser() {} // 01/04/2023 updated to have private visibility, do not change

    /**
     * Done: normalise: returns a standardised copy of a String.
     *  Normalised means:
     *     made entirely lowercase
     *     and with all leading and trailing whitespace removed.
     *
     * @param original
     * @return
     */
    public static String normalise(String original) {
        return
                original.toLowerCase().strip();
    }



}