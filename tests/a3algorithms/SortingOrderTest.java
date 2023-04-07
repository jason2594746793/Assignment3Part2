package a3algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingOrderTest {

    @Test
    void isReversed() {
        assertArrayEquals(new boolean[]{false, false, false, true, true},
                          new boolean[]{SortingOrder.NORMAL.isReversed(),
                                        SortingOrder.NOT_REVERSED.isReversed(),
                                        SortingOrder.DESCENDING.isReversed(),
                                        SortingOrder.ASCENDING.isReversed(),
                                        SortingOrder.REVERSED.isReversed()});
    }
}