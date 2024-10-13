package chapter4;

public interface Shufflable {
    Shufflable NULL = new Shufflable() {
        @Override
        public void shuffle() {
            return;
        }
    };

    void shuffle();
}
