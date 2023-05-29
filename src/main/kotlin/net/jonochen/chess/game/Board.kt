package net.jonochen.chess.game

data class State(val pieces: Map<Triple<Int, Int, Int>, Piece>, val player: Player)

fun init(): State =
    State(
        mapOf(
            Triple(0, 0, 0) to Piece(PieceType.Rook, Player.White),
            Triple(0, 1, 0) to Piece(PieceType.Knight, Player.White),
            Triple(0, 2, 0) to Piece(PieceType.Bishop, Player.White),
            Triple(0, 3, 0) to Piece(PieceType.Queen, Player.White),
            Triple(0, 4, 0) to Piece(PieceType.King, Player.White),
            Triple(0, 5, 0) to Piece(PieceType.Bishop, Player.White),
            Triple(0, 6, 0) to Piece(PieceType.Knight, Player.White),
            Triple(0, 7, 0) to Piece(PieceType.Rook, Player.White),
            Triple(2, 0, 7) to Piece(PieceType.Rook, Player.Black),
            Triple(2, 1, 7) to Piece(PieceType.Knight, Player.Black),
            Triple(2, 2, 7) to Piece(PieceType.Bishop, Player.Black),
            Triple(2, 3, 7) to Piece(PieceType.Queen, Player.Black),
            Triple(2, 4, 7) to Piece(PieceType.King, Player.Black),
            Triple(2, 5, 7) to Piece(PieceType.Bishop, Player.Black),
            Triple(2, 6, 7) to Piece(PieceType.Knight, Player.Black),
            Triple(2, 7, 7) to Piece(PieceType.Rook, Player.Black),
        ),
        Player.White
    )

class Board(val state: State) {

  constructor() : this(init())

  private fun getPiece(st: State, x: Int, y: Int, z: Int): Piece? = st.pieces[Triple(x, y, z)]

  override fun toString(): String {
    var str = ""
    for (i in 2 downTo 0) {
      str += "-=--=--=--=--=--=--=--=-\n"
      for (j in 7 downTo 0) {
        for (k in 0..7) {
          val piece = getPiece(state, i, k, j)
          str += " " + (piece?.toString() ?: "-") + " "
        }
        str += "\n"
      }
    }
    return str
  }
  fun nextState(st: State, mv: Move): State = TODO()
}

