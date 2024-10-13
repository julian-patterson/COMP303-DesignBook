package chapter4;

import java.util.Comparator;

public class Game {
    private Comparator<Card> aComparator = new Comparator<Card>() {
        @Override
        public int compare(Card pCard1, Card pCard2) {
            return pCard1.compareTo(pCard2);
        }
    };

    public Game() {

    }

}
