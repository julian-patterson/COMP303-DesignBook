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
package chapter2;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class Card implements Comparable<Card> {
	private Rank aRank;
	private Suit aSuit;
	private Joker aJoker;

	/**
	 * Creates a new card object.
	 * 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 * @pre pRank != null
	 * @pre pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		if (pRank == Rank.JOKER && pSuit != Suit.NONE) {
			throw new IllegalArgumentException("Joker cannot have a suit");
		}
		aRank = pRank;
		aSuit = pSuit;
		aJoker = Joker.NONE;
	}

	private Card(Joker pJoker) {
		aRank = Rank.JOKER;
		aSuit = Suit.NONE;
		aJoker = pJoker;
	}

	public Card createJoker(Joker pJoker) {
		return new Card(pJoker);
	}

	/**
	 * @return The rank of the card.
	 */
	public Rank getRank() {
		return aRank;
	}

	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit() {
		return aSuit;
	}

	public Joker getJoker() {
		return aJoker;
	}

	@Override
	public int compareTo(Card pCard) {
		return this.aRank.ordinal() - pCard.aRank.ordinal();
	}

	public Card nextCard() {
		Rank nextRank = (this.aRank == Rank.KING) ? Rank.ACE : Rank.values()[this.aRank.ordinal() + 1];

		if (this.aRank == Rank.KING) {
			Suit nextSuit = (this.aSuit == Suit.SPADES) ? Suit.CLUBS : Suit.values()[this.aSuit.ordinal() + 1];
			return new Card(nextRank, nextSuit);
		}
		return new Card(nextRank, this.aSuit);
	}
}
