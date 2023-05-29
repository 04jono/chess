package net.jonochen.chess.game

class IllegalMoveException(message: String) : Exception(message)

data class Move(
    val initial: Triple<Int, Int, Int>,
    val final: Triple<Int, Int, Int>
)

fun moveBoard(bd: Board, move: Move): Board {
  val player = bd.player
  val initPiece = bd.pieces[move.initial]
  if (initPiece == null) {
    throw IllegalMoveException("No initial piece")
  } else {
    val newState = (bd.pieces - move.initial) + Pair(move.final, initPiece)
    return Board(newState, nextPlayer(player))
  }
}
