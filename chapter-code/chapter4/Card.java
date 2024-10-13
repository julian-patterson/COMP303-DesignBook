/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter4;

import java.util.Optional;

/**
 * Implementation of a playing card. This class yields immutable objects.
 * This version of the class shows an application of the Flyweight design
 * pattern where the flyweight store is pre-initialized.
 */
public class Card implements Comparable<Card> {
	// Flyweight store
	private static final Card[][] CARDS = new Card[Suit.values().length][Rank.values().length];

	private enum Joker {
		WHITE, BLACK
	};

	private final Optional<Rank> aRank;
	private final Optional<Suit> aSuit;
	private final Optional<Joker> aJoker;

	private static final Card WHITE_JOKER = new Card(Joker.WHITE);
	private static final Card BLACK_JOKER = new Card(Joker.BLACK);

	// Initialization of the flyweight store
	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(Optional.of(rank), Optional.of(suit));
			}
		}
	}

	// Lazy Initialization of Cards (assuming pre-initialization)
	public static Card getLazyCard(Optional<Rank> pRank, Optional<Suit> pSuit) {
		assert pRank.isPresent() && pSuit.isPresent();
		if (CARDS[pSuit.get().ordinal()][pRank.get().ordinal()] != null) {
			CARDS[pSuit.get().ordinal()][pRank.get().ordinal()] = new Card(pRank, pSuit);
		}
		return CARDS[pSuit.get().ordinal()][pRank.get().ordinal()];
	}

	// Private constructor for joker
	private Card(Joker pJoker) {
		aRank = Optional.empty();
		aSuit = Optional.empty();
		aJoker = Optional.of(pJoker);
	}

	// Private constructor
	private Card(Optional<Rank> pRank, Optional<Suit> pSuit) {
		aRank = pRank;
		aSuit = pSuit;
		aJoker = Optional.empty();
	}

	/**
	 * @param pRank The rank of the requested card.
	 * @param pSuit The suit of the requested card.
	 * @return The unique Card instance with pRank and pSuit
	 * @pre pRank != null && pSuit != null
	 */
	public static Card get(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}

	/**
	 * @return The rank of the card.
	 */
	public Rank getRank() {
		return aRank.get();
	}

	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit() {
		return aSuit.get();
	}

	private boolean isJoker() {
		return aJoker.isPresent();
	}

	/**
	 * @return The Black Joker.
	 */
	public static Card getBlackJoker() {
		return BLACK_JOKER;
	}

	/**
	 * 
	 * @return The White Joker.
	 */
	public static Card getWhiteJoker() {
		return WHITE_JOKER;
	}

	@Override
	public String toString() {
		return String.format("%s of %s", aRank, aSuit);
	}

	@Override
	public boolean equals(Object pObject) {
		if (pObject == null) {
			return false;
		}

		if (pObject.getClass() != getClass()) {
			return false;
		}

		Card pCard = (Card) pObject;

		if ((pCard.getRank() == getRank()) && (pCard.getSuit() == getSuit())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getRank().ordinal() * 2 + getSuit().ordinal();
	}

	@Override
	public int compareTo(Card pCard) {
		if (isJoker() && pCard.isJoker()) {
			return aJoker.get().ordinal() - pCard.aJoker.get().ordinal();
		} else if (isJoker() && !pCard.isJoker()) {
			return 1;
		} else if (!isJoker() && pCard.isJoker()) {
			return -1;
		} else {
			return this.aRank.get().ordinal() - pCard.aRank.get().ordinal();
		}
	}
}
