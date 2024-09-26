package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;;

public class Hand implements IHand, Comparable<Hand>, Iterable<Card> {
    private int aSize;
    private ArrayList<Card> aHand;
    private Comparator<Card> aComparator;

    public Hand(int pSize, Comparator<Card> pComparator) {
        assert pSize > 0;
        aSize = pSize;
        aComparator = pComparator;
    }

    private int countRank() {
        int totalRank = 0;
        for (Card card : aHand) {
            totalRank += card.getRank().ordinal();
        }
        return totalRank;
    }

    public static Comparator<Hand> byRankComparator(Rank pRank) {
        assert pRank != null;

        return new Comparator<Hand>() {
            @Override
            public int compare(Hand pHand1, Hand pHand2) {
                return pHand1.countRank() - pHand2.countRank();
            }
        };
    }

    @Override
    public Iterator<Card> iterator() {
        return aHand.iterator();
    }

    public void test() {
        Iterator<Card> iterator = iterator();

        while (iterator.hasNext()) {

        }
    }

    public ArrayList<Card> add(Card pCard) {
        assert !isFull();
        assert pCard != null;
        assert !contains(pCard);
        aHand.add(pCard);
        return new ArrayList<Card>(aHand);
    }

    public void sort() {
        aHand.sort(aComparator);
    }

    /**
     * 
     * @param pCard
     * @return
     * 
     */
    public boolean contains(Card pCard) {
        assert pCard != null;
        return aHand.contains(pCard);
    }

    public boolean remove(Card pCard) {
        for (Card card : aHand) {
            if (pCard.equals(card)) {
                aHand.remove(pCard);
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Hand pHand) {
        assert pHand != null;
        return this.aHand.size() - pHand.getCards().size();
    }

    public static Comparator<Hand> byIncreasingSize() {
        return new Comparator<Hand>() {
            @Override
            public int compare(Hand pHand1, Hand pHand2) {
                return Integer.compare(pHand1.size(), pHand2.size());
            }
        };
    }

    public static Comparator<Hand> byDecreasingSize() {
        return new Comparator<Hand>() {
            @Override
            public int compare(Hand pHand1, Hand pHand2) {
                return Integer.compare(pHand2.size(), pHand1.size());
            }
        };
    }

    public boolean isEmpty() {
        return aHand.isEmpty();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(aHand);
    }

    public int size() {
        return aHand.size();
    }

    public boolean isFull() {
        return aHand.size() == aSize;
    }

}
