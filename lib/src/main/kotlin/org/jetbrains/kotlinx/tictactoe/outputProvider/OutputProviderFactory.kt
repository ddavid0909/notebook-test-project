package org.jetbrains.kotlinx.tictactoe.outputProvider

/**
 * A factory class responsible for creating instances of various output providers.
 *
 * This abstract factory provides methods to get concrete implementations of output providers
 * for different components of the game, such as the board, spots, players, and messages.
 * These output providers encapsulate the logic needed to output relevant information
 * and are used throughout the game to display results or statuses.
 *
 * WHEN IMPLEMENTING A NEW WAY TO OUTPUT DATA (like UI) CREATE NEW CONCRETE FACTORY.
 */
abstract class OutputProviderFactory {
    abstract fun getBoardOutputProvider(): BoardOutputProvider;
    abstract fun getSpotOutputProvider(): SpotOutputProvider;
    abstract fun getPlayerOutputProvider(): PlayerOutputProvider;
    abstract fun getMessageOutputProvider(): MessageOutputProvider;
}