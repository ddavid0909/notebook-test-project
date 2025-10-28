package org.jetbrains.kotlinx.tictactoe.player



object PlayerFactory {
    val factory = mapOf(
        "random" to {side:String, name:String -> RandomPlayer(side, name) },
        "smart" to {side:String, name:String -> SmartPlayer(side, name) },
        "human" to {side:String, name:String -> StandardPlayer(side, name)}
    )

    fun getPlayer(type: String, side: String, name:String): Player = factory[type]?.invoke(side, name) ?: throw IllegalArgumentException("Unknown player of type $type")

}