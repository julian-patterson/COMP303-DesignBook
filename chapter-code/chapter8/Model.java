package chapter8;

public interface Model {
    private void notifyObservers() {
    };

    void addObserver(DeckObserver pDeckObserver);

    void removeObserver(DeckObserver pDeckObserver);
}
