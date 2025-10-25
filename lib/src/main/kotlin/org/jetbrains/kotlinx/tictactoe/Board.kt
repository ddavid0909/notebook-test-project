package org.jetbrains.kotlinx.tictactoe
import org.jetbrains.kotlinx.tictactoe.player.Player

object Board {
    val spots = Array(3) { Array(3) { Spot() } }
    fun occupy(player: Player, x: Int, y: Int) {
        try {
            spots[x][y].occupy(player)
        } catch (e: Exception) {
            println("Invalid move: $x, $y")
            println(e.message)
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