package net.jonochen.chess.game

class Piece(val type: PieceType, val player: Player) {
    override fun toString(): String {
        return when(type) {
            PieceType.King -> "K"
            PieceType.Rook -> "R"
            PieceType.Bishop -> "B"
            PieceType.Knight -> "N"
            PieceType.Queen -> "Q"
            PieceType.Pawn -> "P"
        }
    }
}

enum class PieceType {
    Pawn,
    Rook,
    Bishop,
    Knight,
    Queen,
    King
}