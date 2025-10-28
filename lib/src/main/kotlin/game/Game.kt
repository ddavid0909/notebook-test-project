package game

import org.jetbrains.kotlinx.tictactoe.outputProvider.OutputProviderFactory
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.jetbrains.kotlinx.tictactoe.status.BoardFullEndCondition
import org.jetbrains.kotlinx.tictactoe.status.ColumnWinCondition
import org.jetbrains.kotlinx.tictactoe.status.DiagonalWinCondition
import org.jetbrains.kotlinx.tictactoe.status.GameStatusCheck
import org.jetbrains.kotlinx.tictactoe.status.RowWinCondition

/**
 * Represents the base structure for a generic game. This abstract class defines the flow and
 * configuration of the game, while delegating specific implementations to subclasses.
 *
 * Concrete games should extend this class and define their own rules for player configurations,
 * win conditions, and end conditions.
 *
 * @property boardOutputProvider Handles the output of the current game board state.
 * @property playerOutputProvider Manages the output information related to players.
 * @property messageOutputProvider Provides output for game messages, such as win or draw announcements.
 * @property players A mutable list of players participating in the game.
 *
 * The `Game` class uses an `OutputProviderFactory` to create specific types of output providers
 * for rendering game information. It uses the `GameStatusCheck` utility for win and end condition handling.
 * GAME CLASS REQUIRES A CUSTOM OUTPUT PROVIDER FACTORY AND IMPLEMENTATION OF CONFIGURE PLAYERS METHOD.
 * OUTPUT PROVIDER FACTORY OUTPUTS GAME STATUS AND ELEMENTS
 * CONFIGURE PLAYERS METHOD INGESTS DATA FROM USER IN A DEFINED MANNER
 */
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