package chapter5.tests;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import chapter5.Card;
import chapter5.PokerHand;
import chapter5.Rank;
import chapter5.Suit;

public class PokerHandTest {
    private PokerHand aPokerHand;

    @Before
    public void setUp() {
        // iniit empty PokerHand
        aPokerHand = new PokerHand();
    }

    @Test
    private void test_isStraightFlush() {
        boolean isStraightFlush = true;
        List<Card> hand = aPokerHand.getCards();
        Suit suit = hand.get(0).getSuit();
        Rank rank = hand.get(0).getRank();
        Iterator<Card> iterator = hand.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getSuit() != suit || card.getRank().ordinal() - rank.ordinal() != 1) {
                isStraightFlush = false;
                break;
            }
            rank = card.getRank();
        }
        assertTrue(isStraightFlush);
    }
}
