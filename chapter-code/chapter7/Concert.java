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
package chapter7;

/**
 * Represents a concert.
 */
public class Concert extends AbstractShow {
    private String aPerformer;

    public Concert(String pTitle, String pPerformer, int pTime) {
        super(pTitle, pTime);
        aPerformer = pPerformer;
    }

    @Override
    public String description() {
        return String.format("%s by %s", super.description(), aPerformer);
    }

    @Override
    public Concert clone() {
        try {
            return (Concert) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}