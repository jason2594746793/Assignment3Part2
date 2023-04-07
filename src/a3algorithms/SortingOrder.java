package a3algorithms;

public enum SortingOrder {
    NORMAL(false),
    NOT_REVERSED(false),
    DESCENDING(false),
    ASCENDING(true),
    REVERSED(true);
    final boolean reversed;// Done: you need to initialise this elsewhere.

    /**
     * DONE: constructor.
     *  Ensure the class variable is initialised.
     *
     *  @param reversed
     */
    SortingOrder(boolean reversed) {
        this.reversed = reversed;
    }

    /**
     * Done: isReversed() checks whether the named sort order is reversed
     *
     * @return
     */
    public boolean isReversed() {
        return reversed;
    }
}
