package chapter8;

public class DrawLogger implements DeckObserver {

    @Override
    public void cardDraw(Card pCard) {
        System.out.println(pCard);
    }

    @Override
    public void cardDraw(DataModel pModel) {
        System.out.println(pModel.cardDraw());
    }

}
