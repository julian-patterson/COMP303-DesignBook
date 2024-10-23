package chapter6;

public class IntroducedShow implements Show {
    private Show aShow;
    private String aSpeaker;
    private int aDuration;

    public IntroducedShow(Show pShow, String pSpeaker, int pDuration) {
        aShow = pShow;
        aSpeaker = pSpeaker;
        aDuration = pDuration;
    }

    @Override
    public String description() {
        return "This show is introduced by " + aSpeaker + ". Show: " + aShow.description();
    }

    @Override
    public int runningTime() {
        return aDuration + aShow.runningTime();
    }

    @Override
    public Show copy() {
        return new IntroducedShow(aShow.copy(), aSpeaker, aDuration);
    }

}
