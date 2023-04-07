package a3algorithms;

public enum Verbosity {
    SILENT(0),
    MINIMUM(1),
    MEDIUM(5),
    MAXIMUM(9);

    private final int verbosityLevel; // Done You'll need to initialise this elsewhere.

    /**
     * Done: constructor
     *  Ensure the class field is initialised.
     *
     * @param verbosityLevel
     */
    Verbosity(int verbosityLevel) {
        this.verbosityLevel = verbosityLevel;
    }

    /**
     * Done: getVerbosityLevel():
     *  Returns the verbosity of the current enum value.
     *
     * @return
     */
    public int getVerbosityLevel() {
        return verbosityLevel;
    }

    /**
     * Done: isVerbose():
     *   It is not verbose if the number is 0 or lower.
     * @return
     */
    public boolean isVerbose() {
        return verbosityLevel > 0;
    }
}
