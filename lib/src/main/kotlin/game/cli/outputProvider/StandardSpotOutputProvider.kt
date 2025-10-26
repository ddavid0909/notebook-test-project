package game.cli.outputProvider

import org.jetbrains.kotlinx.tictactoe.Spot
import org.jetbrains.kotlinx.tictactoe.outputProvider.SpotOutputProvider

class StandardSpotOutputProvider: SpotOutputProvider() {
    override fun output(spot: Spot) {
        val spotVal = if (spot.player == null) ' ' else spot.player?.side
        print("$spotVal")
    }
}