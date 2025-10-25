package org.jetbrains.kotlinx.tictactoe

import org.jetbrains.kotlinx.tictactoe.exceptions.SpotOccupiedException
import org.jetbrains.kotlinx.tictactoe.player.HumanPlayer
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardTest {
    val player: Player = HumanPlayer("X", "Player 1")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun occupyEmptySpot() {
        val board = Board
        board.occupy(player, 0, 0)
        assertEquals(player, board.spots[0][0].getPlayer())
    }

    @Test
    fun occupyOccupiedSpot() {
        val board = Board
        board.occupy(player, 0, 0)
        assertThrows(
            SpotOccupiedException::class.java,
            { board.occupy(player, 0, 0) },
            "Should throw SpotOccupiedException when occupying occupied spot"
        )
    }

    @Test
    fun occupyInvalidSpot() {
        val board = Board
        assertThrows(
            IndexOutOfBoundsException::class.java,
            { board.occupy(player, -1, -1) },
            "Should throw IndexOutOfBoundsException when occupying invalid spot"
        )
    }

}