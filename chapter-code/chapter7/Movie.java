package chapter7;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie extends AbstractShow {
    private int aYear;

    public Movie(String pTitle, int pYear, int pTime) {
        super(pTitle, pTime);
        aYear = pYear;
    }

    @Override
    public String description() {
        return String.format("%s (%d)", super.description(), aYear);
    }

    @Override
    public void setTitle(String pTitle) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTime(int pTime) {
        assert pTime > 10;
        setTime(pTime);
    }

    public void setTime(int hours, int minutes) {
        setTime(hours * 60 + minutes);
    }

    public Movie getRecommenedShow() {
        return (Movie) super.getRecommenedShow();
    }

    public void setRecommendedShow(Movie pRecommenedMovie) {
        super.setRecommendedShow(pRecommenedMovie);
    }

    @Override
    public Movie clone() {
        try {
            return (Movie) super.clone();
        } catch (Exception e) {
            return null;
        }
    }
}