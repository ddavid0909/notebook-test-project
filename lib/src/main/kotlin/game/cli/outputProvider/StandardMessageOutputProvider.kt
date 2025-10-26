package game.cli.outputProvider

import org.jetbrains.kotlinx.tictactoe.outputProvider.MessageOutputProvider

class StandardMessageOutputProvider: MessageOutputProvider() {
    override fun output(message: String) {
        println(message)
    }
}