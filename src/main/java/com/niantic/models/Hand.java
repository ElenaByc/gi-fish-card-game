package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void dealTo(Card card) {
        cards.add(card);
    }

    public void displayCards() {
        sortCarts();
        for (var card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    private void sortCarts() {
        Collections.sort(cards);
    }

    public ArrayList<Card> returnCardsByFaceValue(String value, boolean removeFromHand) {
        ArrayList<Card> requestedCards = new ArrayList<>();
        ArrayList<Integer> indexesToRemove = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getFaceValue().getDisplayValue().equalsIgnoreCase(value)) {
                requestedCards.add(card);
                indexesToRemove.add(i);
            }
        }

        if (removeFromHand) {
            System.out.println("Indexes to remove:");
            System.out.println(indexesToRemove);
            for (int i = indexesToRemove.size() - 1; i >= 0; i--) {
                cards.remove((int) indexesToRemove.get(i));
            }
            System.out.println("cards after removing:");
            displayCards();
        }

        return requestedCards;
    }

    public Card getCardByIndex(int idx) {
        return cards.get(idx);
    }
}
