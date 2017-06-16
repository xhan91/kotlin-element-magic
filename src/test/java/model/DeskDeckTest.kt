package model

import org.junit.Test

/**
 * Created by xhan91 on 2017-06-15.
 */
class DeskDeckTest {

    @Test
    fun testInit() {
        val deck = DeskDeck()
        deck.generateOriginalDeck()
        println("INIT:")
        println(deck)
        deck.shuffle()
        println("SHUFFLE:")
        println(deck)
    }
}