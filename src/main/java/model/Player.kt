package model

/**
 * Created by xhan91 on 2017-06-16.
 */
class Player(private val name: String,
             private val game: Game) {
    companion object {
        val MAX_HEALTH = 30
        val MAX_HAND_DECK = 8
    }

    private var health = 30
    private var shield = 0
    private val handDeck = HandDeck()

    fun takeOneCard() = handDeck.put(game.gameDeck.takeFromIndex(0))
    fun takeStartingCards() = (1..8).forEach { _ -> takeOneCard() }
    // drop cards more than max
    fun finishTurn() {
        while (handDeck.cards.size > MAX_HAND_DECK) {
            handDeck.takeFromIndex(0)
        }
    }

    fun takeDamage(isTrue: Boolean, amount: Int) {
        assert(amount >= 0)
        if (isTrue) {
            health -= amount;
        } else {
            if (shield > amount) {
                shield -= amount
            } else if (shield > 0) {
                val leftDmg = amount - shield
                shield = 0
                health -= leftDmg
            } else {
                health -= amount
            }
        }
        if (health <= 0) {
            game.gameOver()
        }
    }

    fun getHeal(amount: Int) = if (health + amount < MAX_HEALTH) health += amount else health = MAX_HEALTH

}