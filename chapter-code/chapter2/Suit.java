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
 * Represents the suit of a playing card.
 */
public enum Suit {
	CLUBS, DIAMONDS, SPADES, HEARTS, NONE;

	public Color color() {
		if (this == CLUBS || this == SPADES) {
			return Color.BLACK;
		}
		return Color.RED;
	}

	public Suit next() {
		if (this == Suit.HEARTS) {
			return Suit.CLUBS;
		} else {
			return Suit.values()[this.ordinal() + 1];
		}
	}
}
