package chapter7;

public class SponsoredConcert extends Concert {
    private String aSponsorName;
    private int aSponsorTime;

    public SponsoredConcert(String pTitle, String pPerformer, int pTime, String pSponsorName, int pSponsorTime) {
        super(pTitle, pPerformer, pTime);
        aSponsorName = pSponsorName;
        aSponsorTime = pSponsorTime;
    }

    @Override
    public int time() {
        return aSponsorTime + super.time();
    }

    @Override
    public String description() {
        return String.format("%s sponsored by %s [%d time]", super.description(), aSponsorName, aSponsorTime);
    }

    @Override
    public SponsoredConcert clone() {
        try {
            return (SponsoredConcert) super.clone();
        } catch (Exception e) {
            return null;
        }

    }
}