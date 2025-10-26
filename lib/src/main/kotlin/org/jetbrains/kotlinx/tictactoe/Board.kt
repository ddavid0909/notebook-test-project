package org.jetbrains.kotlinx.tictactoe
import org.jetbrains.kotlinx.tictactoe.player.Player

object Board {
    val spots = Array(3) { Array(3) { Spot() } }
    fun occupy(player: Player, position: Position) {
        val (x, y) = position
        try {
            spots[x][y].occupy(player)
        } catch (e: Exception) {
            throw e
        }
    }

    fun reset() {
        for (x in spots.indices) {
            for (y in spots[x].indices) {
                spots[x][y].clear()
            }
        }
    }
}