package game.cli.outputProvider

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.outputProvider.BoardOutputProvider

class StandardBoardOutputProvider: BoardOutputProvider() {
    override fun output() {
        val spotOutputProvider = StandardOutputProviderFactory.getSpotOutputProvider()
        val board = Board.spots
        for (row in board) {
            println("---")
            for (spot in row) {
                spotOutputProvider.output(spot)
            }
            println()
        }
        print("---")
        println()
    }
}