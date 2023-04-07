package a3algorithms;

/**
 * Stores a word with its frequency of usage.
 * This word has no knowledge of any other words.
 */
public class SimpleFrequencyWord implements Comparable<SimpleFrequencyWord> {
    protected final String word;
    protected int count;
    /**
     * Done: constructor.
     *  Ensure class variables are initialised.
     *
     * @param word
     */
    SimpleFrequencyWord(String word) {
        this.word = word;
        count = 1;
    }

    /**
     * Done: getWord() is the getter for the core word.
     *
     * @return
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Done: getCount() is the getter for the current word frequency.
     */
    public int getCount() {
        return count;
    }

    /**
     * Done: incrementCount by one.
     */
    public void incrementCount() {
        count++;
    }

    /**
     * Done: toString generates a one-line String according to the pattern
     *              digits right-justified in 4 spaces
     *              tab
     *              the word
     */
    @Override
    public String toString() {
        return String.format("%4d\t%s", count, word);
    }

    /**
     * Done: toString(String) prints the word according to the supplied pattern.
     *
     * @param wordStatePattern
     * @return
     */
    public String toString(String wordStatePattern) {
        return String.format(wordStatePattern, count, word);
    }

    /**
     * Done: compareTo() knows how to compare this object with another of the same type.
     *          You need to learn how to do this.
     *
     * @param other the counterpart object to be compared with.
     * @return
     */
    @Override
    public int compareTo(SimpleFrequencyWord other) {
        return Integer.compare(count, other.count);
    }
}
