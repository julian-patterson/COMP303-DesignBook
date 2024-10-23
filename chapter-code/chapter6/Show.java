package chapter6;

import java.util.Collections;
import java.util.Iterator;

/**
 * Represents a performance that can take place in a theater. All
 * implementations
 * of this interface should be immutable.
 */
public interface Show extends Iterable<Show> {
    /**
     * @return A description of the show.
     */
    String description();

    /**
     * @return The running time of the show, in minutes.
     */
    int runningTime();

    Show copy();

    @Override
    default Iterator<Show> iterator() {
        return Collections.emptyIterator();
    }

}