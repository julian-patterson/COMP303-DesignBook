package chapter6;

import java.util.ArrayList;
import java.util.Iterator;

public class DoubleBill implements Show {
    private Movie aMovie1;
    private Movie aMovie2;

    public DoubleBill(Movie pMovie1, Movie pMovie2) {
        aMovie1 = pMovie1;
        aMovie2 = pMovie2;
    }

    @Override
    public String description() {
        return aMovie1.description() + ". Movie 2: " + aMovie2.description();
    }

    @Override
    public int runningTime() {
        return aMovie1.runningTime() + aMovie2.runningTime();
    }

    @Override
    public Iterator<Show> iterator() {
        ArrayList<Show> aShows = new ArrayList<>();
        aShows.add(aMovie1);
        aShows.add(aMovie2);
        return aShows.iterator();
    }

    @Override
    public Show copy() {
        return new DoubleBill((Movie) aMovie1.copy(), (Movie) aMovie2.copy());
    }

}
