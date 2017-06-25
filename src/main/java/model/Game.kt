package model

import java.util.*
import kotlin.properties.Delegates

/**
 * Created by xhan91 on 2017-06-17.
 */
class Game {

    var gameDeck = DeskDeck()
    var tombDeck = DeskDeck()
    val player1 = Player("player1", this)
    val player2 = Player("player2", this)
    val skillChain = LinkedList<Skill>()

    fun swapGameAndTombDeck() {
        var tmp = gameDeck
        gameDeck = tombDeck
        tombDeck = gameDeck
    }

    fun gameOver() {

    }
}