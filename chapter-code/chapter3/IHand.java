package chapter3;

import java.util.ArrayList;

public interface IHand {
    ArrayList<Card> add(Card pCard);

    boolean remove(Card pCard);

    boolean contains(Card pCard);

    boolean isEmpty();

    int size();

    boolean isFull();
}
