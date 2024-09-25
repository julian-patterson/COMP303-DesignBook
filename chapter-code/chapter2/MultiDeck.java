package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiDeck {
    private List<Deck> aDecks = new ArrayList<>();

    /**
     * Creates a multideck
     * 
     * @param pDecks Decks that you want in the multiDeck
     * @pre pDecks != null
     * @return List<Deck> of object
     * 
     */
    public MultiDeck(Deck... pDecks) {
        assert pDecks != null;
        aDecks.addAll(Arrays.asList(pDecks));
    }

    /**
     * @pre pOriginalDeck != null
     * @param pOriginalDeck
     */
    public MultiDeck(MultiDeck pOriginalDeck) {
        assert pOriginalDeck != null;
        this.aDecks = new ArrayList<>(pOriginalDeck.aDecks);
    }

    public List<Deck> shallowCopy() {
        return List.copyOf(aDecks);
    }

    public List<Deck> deepCopy() {
        List<Deck> result = new ArrayList<>();
        for (Deck deck : aDecks) {
            result.add(new Deck(deck));
        }
        return result;
    }
}
