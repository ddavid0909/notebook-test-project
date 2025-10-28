package org.jetbrains.kotlinx.tictactoe.outputProvider

/**
 * Abstract class representing an output provider for message-related communication.
 *
 * This class is part of the output provider abstraction, responsible for handling
 * the output of textual messages in the game. Implementations of this class define
 * how messages are displayed or presented.
 *
 * By abstracting message output, it allows the flexibility to implement and switch
 * between different output mechanisms, such as console output, GUI notifications, or logs.
 */
abstract class MessageOutputProvider {
    abstract fun output(message: String)
}