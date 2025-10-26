package game.cli.outputProvider

import org.jetbrains.kotlinx.tictactoe.outputProvider.MessageOutputProvider
import org.jetbrains.kotlinx.tictactoe.outputProvider.OutputProviderFactory

object StandardOutputProviderFactory: OutputProviderFactory() {
    override fun getBoardOutputProvider(): StandardBoardOutputProvider {
        return StandardBoardOutputProvider()
    }

    override fun getSpotOutputProvider(): StandardSpotOutputProvider {
        return StandardSpotOutputProvider()
    }

    override fun getPlayerOutputProvider(): StandardPlayerOutputProvider {
        return StandardPlayerOutputProvider()
    }

    override fun getMessageOutputProvider(): MessageOutputProvider {
        return StandardMessageOutputProvider()
    }
}