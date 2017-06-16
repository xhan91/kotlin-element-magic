package model

import enum.Suit

/**
 * Created by xhan91 on 2017-06-13.
 */
class Card(private val suit: Suit, private val value: Int) {
    override fun toString(): String {
        return "Suit: $suit, Value: $value"
    }
}
