package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

/**
 * SmartPlayer chooses moves using Minimax + alpha-beta on an immutable BoardState copy.
 * Assumes sides are the strings "X" and "O".
 */
class SmartPlayer(side: String, name: String) : Player(side, name) {

    override fun getInput(): Position {
        val initialState = boardToState(this.side)

        val (bestPos, _) = minimax(initialState, depth = 0, alpha = Int.MIN_VALUE, beta = Int.MAX_VALUE, maximizingSide = this.side)

        return bestPos ?: throw IllegalStateException("SmartPlayer: no valid moves available")
    }
    private fun otherSide(side: String): String = if (side == "X") "O" else "X"
    private fun minimax(
        state: BoardState,
        depth: Int,
        alpha: Int,
        beta: Int,
        maximizingSide: String
    ): Pair<Position?, Int> {
        var a = alpha
        var b = beta

        when (state.status()) {
            BoardStatus.WIN -> {
                val lastMover = otherSide(state.currentSide)
                return if (lastMover == maximizingSide) {
                    null to (10 - depth)
                } else {
                    null to (depth - 10)
                }
            }
            BoardStatus.DRAW -> return null to 0
            BoardStatus.PROGRESS -> {
            }
        }

        val free = state.freePositions()
        if (free.isEmpty()) return null to 0

        var bestMove: Position? = null
        var bestScore = if (state.currentSide == maximizingSide) Int.MIN_VALUE else Int.MAX_VALUE
        val isMaximizing = (state.currentSide == maximizingSide)

        for (pos in free) {
            // Apply move on a copied state
            val nextState = state.play(pos, state.currentSide)

            val (_, score) = minimax(nextState, depth + 1, a, b, maximizingSide)

            if (isMaximizing) {
                if (score > bestScore) {
                    bestScore = score
                    bestMove = pos
                }
                a = maxOf(a, bestScore)
            } else {
                if (score < bestScore) {
                    bestScore = score
                    bestMove = pos
                }
                b = minOf(b, bestScore)
            }

            if (b <= a) break
        }

        return bestMove to bestScore
    }

    private enum class BoardStatus { WIN, DRAW, PROGRESS }

    private data class BoardState(
        val spots: Array<Array<String?>>,
        val currentSide: String
    ) {

        fun status(): BoardStatus {

            val winner = detectWinner()
            if (winner != null) return BoardStatus.WIN

            for (i in spots.indices) {
                for (j in spots[i].indices) {
                    if (spots[i][j] == null) return BoardStatus.PROGRESS
                }
            }
            return BoardStatus.DRAW
        }
        private fun otherSide(side: String): String = if (side == "X") "O" else "X"
        private fun detectWinner(): String? {
            for (i in 0..2) {
                val a = spots[i][0]
                if (a != null && a == spots[i][1] && a == spots[i][2]) return a
            }
            for (j in 0..2) {
                val a = spots[0][j]
                if (a != null && a == spots[1][j] && a == spots[2][j]) return a
            }
            val d1 = spots[0][0]
            if (d1 != null && d1 == spots[1][1] && d1 == spots[2][2]) return d1
            val d2 = spots[0][2]
            if (d2 != null && d2 == spots[1][1] && d2 == spots[2][0]) return d2
            return null
        }


        fun play(pos: Position, side: String): BoardState {
            val copy = Array(3) { i -> Array<String?>(3) { j -> spots[i][j] } }
            copy[pos.x][pos.y] = side
            return BoardState(copy, otherSide(side))
        }

        fun freePositions(): List<Position> {
            val list = mutableListOf<Position>()
            for (i in spots.indices) {
                for (j in spots[i].indices) {
                    if (spots[i][j] == null) list.add(Position(i, j))
                }
            }
            return list
        }
    }

    private fun boardToState(currentSide: String): BoardState {
        val arr = Array(3) { Array<String?>(3) { null } }
        for (i in Board.spots.indices) {
            for (j in Board.spots[i].indices) {
                arr[i][j] = Board.spots[i][j].player?.side
            }
        }
        return BoardState(arr, currentSide)
    }


}
