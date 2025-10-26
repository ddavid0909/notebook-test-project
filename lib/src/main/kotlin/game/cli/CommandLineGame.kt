package game.cli

import game.Game
import org.jetbrains.kotlinx.tictactoe.inputProvider.InputProviderFactory
import game.cli.outputProvider.StandardOutputProviderFactory
import org.jetbrains.kotlinx.tictactoe.player.Player

class CommandLineGame: Game(StandardOutputProviderFactory) {

    override fun configurePlayers(): List<Player>{
        val list = mutableListOf<Player>()
        list.add(configurePlayer("X"))
        list.add(configurePlayer("O"))
        return list
    }


    private fun configurePlayer(side: String): Player {
        while(true) {
            try {
                println("Enter player $side type : ${InputProviderFactory.factory.keys}:")
                val type = readln()
                val inputProvider = InputProviderFactory.getInputProvider(type)

                println("Enter player $side name:")
                val name = readln()
                return Player(side, name, inputProvider)

            } catch(e: RuntimeException) {
                println(e.message)
            }
        }
    }

}