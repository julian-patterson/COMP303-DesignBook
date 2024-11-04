package chapter7;

public abstract class AbstractShow implements Show, Cloneable {
    private String aTitle;
    private int aTime;
    private Show aRecommenedShow;

    public AbstractShow(String pTitle, int pTime) {
        aTime = pTime;
        aTitle = pTitle;
    }

    public int time() {
        return aTime;
    }

    public String title() {
        return aTitle;
    }

    public String description() {
        return String.format("%s: (%d minutes)", title(), time());
    }

    public void setTitle(String pTitle) {
        aTitle = pTitle;
    }

    /**
     * 
     * @param pTime
     * @pre pTime > 0
     */
    public void setTime(int pTime) {
        assert pTime > 0;
        aTime = pTime;
    }

    public void setTime(int hours, int minutes) {
        aTime = hours * 60 + minutes;
    }

    public Show getRecommenedShow() {
        return aRecommenedShow;
    }

    public void setRecommendedShow(Show pRecommenedShow) {
        aRecommenedShow = pRecommenedShow;
    }

    public AbstractShow clone() throws CloneNotSupportedException {
        try {
            return (AbstractShow) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new CloneNotSupportedException("Clone not able");
        }
    }
}
