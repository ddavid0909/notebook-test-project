package org.jetbrains.kotlinx.tictactoe

import org.jetbrains.kotlinx.tictactoe.exceptions.SpotOccupiedException
import org.jetbrains.kotlinx.tictactoe.player.Player

class Spot {
    var player: Player? = null
    fun occupy(player: Player) {
        if (!this.isFree()) throw SpotOccupiedException()
        this.player = player
    }

    fun isFree(): Boolean {
        return this.player == null
    }

    fun clear() {
        this.player = null
    }
}