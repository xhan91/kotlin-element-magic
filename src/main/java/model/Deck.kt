package model

import enum.Suit
import java.util.*

/**
 * Created by xhan91 on 2017-06-13.
 */
interface IDeck {

    fun put(card: Card)

    fun takeFromIndex(index: Int): Card

}

abstract class AbstractDeck: IDeck {

    val cards: MutableList<Card> = ArrayList()

    override fun put(card: Card) {
        cards.add(card)
    }

    override fun takeFromIndex(index: Int): Card {
        return cards.removeAt(index)
    }


}

class DeskDeck(): AbstractDeck() {

    val sub1: MutableList<Card> = ArrayList()
    val sub2: MutableList<Card> = ArrayList()

    fun generateOriginalDeck() = if (cards.size > 0) {
        throw Exception("The function should not be called after cards has been initialized.")
    } else {
        for (suit in Suit.values()) {
            when (suit) {
                Suit.Joker -> {
                    cards.add(Card(suit, 1))
                    cards.add(Card(suit, 2))
                }
                else -> {
                    (1..13).mapTo(cards) { Card(suit, it) }
                }
            }
        }
    }

    // seems not efficient
    fun shuffle() {
        val random = Random(Date().time)
        for (i in 1..5) {
            while (cards.size > 0) {
                val sub = if (random.nextBoolean()) sub1 else sub2
                sub.add(cards.removeAt(0))
            }
            while (sub1.size > 0) {
                cards.add(sub1.removeAt(0))
            }
            while (sub2.size > 0) {
                cards.add(sub2.removeAt(0))
            }
        }
    }

    override fun toString(): String {
        return cards.joinToString(separator = "\n")
    }
}