package game

import org.jetbrains.kotlinx.tictactoe.outputProvider.OutputProviderFactory
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.jetbrains.kotlinx.tictactoe.status.BoardFullEndCondition
import org.jetbrains.kotlinx.tictactoe.status.ColumnWinCondition
import org.jetbrains.kotlinx.tictactoe.status.DiagonalWinCondition
import org.jetbrains.kotlinx.tictactoe.status.GameStatusCheck
import org.jetbrains.kotlinx.tictactoe.status.RowWinCondition

abstract class Game(outputProviderFactory: OutputProviderFactory) {
    val boardOutputProvider = outputProviderFactory.getBoardOutputProvider()
    val playerOutputProvider = outputProviderFactory.getPlayerOutputProvider()
    val messageOutputProvider = outputProviderFactory.getMessageOutputProvider()
    var players : List<Player> = mutableListOf()

    open fun start() {
        var index = 0
        var currentPlayer: Player = players[index]
        while(GameStatusCheck.check() == "PROGRESS") {
            currentPlayer = players[index]
            playerOutputProvider.output(currentPlayer)
            boardOutputProvider.output()

            while(true) {
                try {
                    currentPlayer.makeMove()
                    break
                } catch(e: RuntimeException) {
                    println(e.message)
                }

            }
            index = (index + 1) % players.size
        }
        if(GameStatusCheck.check() == "WIN") {
            messageOutputProvider.output("The winner is ${currentPlayer.side}: ${currentPlayer.name}!")
        } else {
            messageOutputProvider.output("The game ended in a draw!")
        }
        boardOutputProvider.output()
    }

    abstract fun configurePlayers(): List<Player>;
    open fun configureWinConditions() {
        GameStatusCheck.addWinCondition(RowWinCondition())
        GameStatusCheck.addWinCondition(ColumnWinCondition())
        GameStatusCheck.addWinCondition(DiagonalWinCondition())
    }
    open fun configureEndConditions() {
        GameStatusCheck.addEndCondition(BoardFullEndCondition())
    }

    open fun run() {
        this.players = configurePlayers()
        configureWinConditions()
        configureEndConditions()
        start()
    }
}