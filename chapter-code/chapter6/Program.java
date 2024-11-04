package chapter6;

import java.util.EnumMap;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * Each day of the week must be associated with exactly one
 * Show object. If there is not show on a given day, a special
 * object of type show is used to represent a "non-show".
 */
public class Program {
    private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
    private final Show NULL_SHOW = createNullShow();

    public Program() {
        for (Day day : aShows.keySet()) {
            aShows.put(day, NULL_SHOW);
        }
    }

    public Show createNullShow() {
        return new Show() {
            @Override
            public boolean isNull() {
                return true;
            }

            @Override
            public String description() {
                return "";
            }

            @Override
            public int runningTime() {
                return 0;
            }

            @Override
            public Show copy() {
                return createNullShow();
            }
        };
    }

    public Command createClearCommand() {
        return new Command() {
            EnumMap<Day, Show> previousProgram;

            @Override
            public void execute() {
                previousProgram = new EnumMap<>(previousProgram);
                clear();
            }

            @Override
            public void undo() {
                aShows.putAll(previousProgram);
            }

        };
    }

    public Command createAddCommand(Day pDay, Show pShow) {
        return new Command() {
            Show previousShow;

            @Override
            public void execute() {
                previousShow = aShows.get(pDay);
                aShows.put(pDay, pShow);
            }

            @Override
            public void undo() {
                aShows.put(pDay, previousShow);
            }

        };
    }

    public Command createRemoveCommand(Day pDay) {
        return new Command() {
            Show previousShow;

            @Override
            public void execute() {
                previousShow = aShows.get(pDay);
                aShows.put(pDay, NULL_SHOW);
            }

            @Override
            public void undo() {
                aShows.put(pDay, previousShow);
            }

        };
    }

    /**
     * Clear the program by removing all existing shows.
     */
    public void clear() {
        for (Day day : aShows.keySet()) {
            aShows.put(day, NULL_SHOW);
        }
    }

    /**
     * Adds a new show to the program. Overrides any existing show
     * on that day.
     * 
     * @param pShow The show to add.
     * @param pDay  The day when the show takes place.
     */
    public void add(Show pShow, Day pDay) {
        assert pShow != null && pDay != null;
        aShows.put(pDay, pShow);
    }

    /**
     * Removes a show from the program.
     * 
     * @param pDay The day when we want to zap the show.
     */
    public void remove(Day pDay) {
        assert pDay != null;
        aShows.put(pDay, NULL_SHOW);
    }

    /**
     * @param pDay The day of the requested show.
     * @return A copy of the show on a given day.
     */
    public Show get(Day pDay) {
        assert pDay != null;
        return aShows.get(pDay);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : aShows.keySet()) {
            if (aShows.containsKey(day)) {
                result.append(String.format("%9s", day.name()))
                        .append(": ").append(aShows.get(day).description()).append("\n");
            }
        }
        return result.toString();
    }
}