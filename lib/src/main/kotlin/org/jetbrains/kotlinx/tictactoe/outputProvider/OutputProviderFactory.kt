package org.jetbrains.kotlinx.tictactoe.outputProvider

abstract class OutputProviderFactory {
    abstract fun getBoardOutputProvider(): BoardOutputProvider;
    abstract fun getSpotOutputProvider(): SpotOutputProvider;
    abstract fun getPlayerOutputProvider(): PlayerOutputProvider;
    abstract fun getMessageOutputProvider(): MessageOutputProvider;
}