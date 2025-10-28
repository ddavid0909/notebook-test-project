package org.jetbrains.kotlinx.tictactoe

/**
 * Represents a position on a 2D board with `x` and `y` coordinates.
 *
 * The `x` and `y` coordinates are used to indicate a specific spot
 * on the board in games such as Tic-Tac-Toe. This class is often used
 * in conjunction with board-related operations to reference or manipulate
 * specific positions.
 *
 * @property x The row coordinate of the position (0-indexed).
 * @property y The column coordinate of the position (0-indexed).
 */
data class Position(val x: Int, val y: Int)