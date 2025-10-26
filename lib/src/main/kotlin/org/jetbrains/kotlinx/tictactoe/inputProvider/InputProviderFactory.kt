package org.jetbrains.kotlinx.tictactoe.inputProvider

import game.cli.inputProvider.StandardInputProvider

object InputProviderFactory {
    val factory = mapOf(
        "random" to { RandomInputProvider() },
        "smart" to { SmartInputProvider() },
        "human" to { StandardInputProvider() }
    )

    fun getInputProvider(name: String): InputProvider = factory[name]?.invoke() ?: throw IllegalArgumentException("Unknown input provider: $name")

}