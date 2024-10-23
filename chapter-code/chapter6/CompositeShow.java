package chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeShow implements Show, Iterable<Show> {
    private List<Show> aShows = new ArrayList<>();

    public CompositeShow(ArrayList<Show> pShows) {
        assert pShows != null;
        if (pShows.size() > 1 && pShows.size() < 6) {
            aShows = new ArrayList<>(pShows);
        }
    }

    public void addShow(Show pShow) {
        if (aShows.size() <= 4) {
            aShows.add(pShow);
        }
    }

    public String description() {
        String description = "";
        for (Show aShow : aShows) {
            description = description + aShow.description();
        }
        return description;
    }

    public Show copy() {
        ArrayList<Show> copyShows = new ArrayList<>();
        for (Show aShow : aShows) {
            copyShows.add(aShow.copy());
        }
        return new CompositeShow(copyShows);
    }

    public int runningTime() {
        int totalRunningTime = 0;
        for (Show aShow : aShows) {
            totalRunningTime += aShow.runningTime();
        }
        return totalRunningTime;
    }

    @Override
    public Iterator<Show> iterator() {
        return aShows.iterator();
    }
}
