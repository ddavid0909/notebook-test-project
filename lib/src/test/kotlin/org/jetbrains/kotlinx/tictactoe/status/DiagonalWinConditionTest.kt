package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DiagonalWinConditionTest {
    val player: Player = Player("X", "Player 1")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkDiagonalWin0() {
        val board = Board
        board.occupy(player, Position(0, 0))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(2,2))
        assertTrue(DiagonalWinCondition().check(), "Main diagonal should be winning")
    }

    @Test
    fun checkDiagonalWin1() {
        val board = Board
        board.occupy(player, Position(0,2))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(2,0))
        assertTrue(DiagonalWinCondition().check(), "Secondary diagonal should be winning")
    }

    @Test
    fun checkNotDiagonalWin() {
        val board = Board
        board.occupy(player, Position(0,0))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(0,2))
        assertFalse(DiagonalWinCondition().check(), "No diagonal should be winning")
    }

}