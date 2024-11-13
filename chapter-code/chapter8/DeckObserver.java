package chapter8;

public interface DeckObserver {
    default void cardDraw(Card pCard) {
    };

    default void sizeChange(int size) {
    };

    default void cardDraw(DataModel pModel) {

    }

    default void sizeChange(DataModel pModel) {

    }
}
