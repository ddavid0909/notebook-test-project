package game.cli

import game.Game
import game.cli.outputProvider.StandardOutputProviderFactory
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.jetbrains.kotlinx.tictactoe.player.PlayerFactory

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
                println("Enter player $side type : ${PlayerFactory.factory.keys}:")
                val type = readln()
                println("Enter player $side name:")
                val name = readln()
                return PlayerFactory.getPlayer(type, side, name)
            } catch(e: RuntimeException) {
                println(e.message)
            }
        }
    }

}