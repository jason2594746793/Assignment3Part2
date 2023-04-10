package literatureStats;

/**
 * A FrequencyDocumentPG stores all the words and their words of a
 * Project Gutenberg ebook. This means it only stores the words of the actual
 * text and not the preamble and postamble added by Project Gutenberg.
 * <p>
 * Every instance must have a configuration file {@link FrequencyReaderConfig}
 */
public class FrequencyDocumentPG extends FrequencyDocument {
    public static final String PG_DOCUMENT_START =
            "*** START OF THE PROJECT GUTENBERG EBOOK";
    public static final String PG_DOCUMENT_STOP =
            "*** END OF THE PROJECT GUTENBERG EBOOK";

    /**
     * DONE: default constructor is the parent's constructor. This should be a
     * one-liner.
     */
    public FrequencyDocumentPG() {
        super();
    }

    /**
     * DONE: constructor based on a filename. Use the defaults for information
     * not provided.
     *
     * @param filename
     */
    public FrequencyDocumentPG(String filename) {
        this.initialise(filename);
    }

    /**
     * DONE: constructor for filename and a pattern specifying characters
     * that are not allowed in words. Use the defaults for information not
     * provided.
     *
     * @param filename
     * @param nonWordChars
     */
    public FrequencyDocumentPG(String filename, String nonWordChars) {
        this.initialise(filename, nonWordChars);
    }

    /**
     * DONE: constructor using a configuration object. Use the defaults for
     * information not provided.
     *
     * @param config
     */
    public FrequencyDocumentPG(FrequencyReaderConfig config) {
        super(config);
    }

    /**
     * DONE: constructor using a configuration object and a pattern
     * specifying characters that are not allowed in words. This version
     * is provided with all the information it needs and should be a one-liner.
     *
     * @param config
     * @param nonWordChars
     */
    public FrequencyDocumentPG(FrequencyReaderConfig config,
                               String nonWordChars) {
           super(config, nonWordChars);
    }

    /**
     * DONE: Initialise based on a filename. Use the defaults for information
     * not provided.
     *
     * @param filename
     */
    @Override
    public void initialise(String filename) {
        this.initialise(filename, FrequencyDocumentReader.DEFAULT_NON_WORD_CHARS);
    }

    /**
     * DONE: constructor using a filename and a pattern specifying characters
     * that are not allowed in words. Use the defaults for information not
     * provided.
     *
     * @param filename
     * @param nonWordChars
     */
    @Override
    public void initialise(String filename, String nonWordChars) {
        setConfig(new FrequencyReaderConfig(filename, PG_DOCUMENT_START, PG_DOCUMENT_STOP, FrequencyReaderConfig.DEFAULT_VERBOSITY));
        setNonWordChars(nonWordChars);
    }
}