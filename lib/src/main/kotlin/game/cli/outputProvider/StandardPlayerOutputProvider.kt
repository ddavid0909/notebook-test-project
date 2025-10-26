package game.cli.outputProvider

import org.jetbrains.kotlinx.tictactoe.outputProvider.PlayerOutputProvider
import org.jetbrains.kotlinx.tictactoe.player.Player

class StandardPlayerOutputProvider: PlayerOutputProvider() {
    override fun output(player: Player) {
        println("Player ${player.name} (${player.side})'s turn!")
    }
}