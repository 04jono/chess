package net.jonochen.chess.service

import net.jonochen.chess.game.Board
import net.jonochen.chess.game.Move
import net.jonochen.chess.game.moveBoard
import net.jonochen.chess.model.BoardModel
import net.jonochen.chess.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GameService(@Autowired val repo: Repository) {

  fun tripleToString(triple: Triple<Int, Int, Int>): String =
      triple.first.toString() + "," + triple.second.toString() + "," + triple.third.toString()

  fun stringToTriple(s: String): Triple<Int, Int, Int> {
    val split = s.split(",")
    return Triple(
        Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]))
  }

  fun createNewBoard(): BoardModel {
    val newBoard = Board()
    val newBoardMap = newBoard.pieces.mapKeys { tripleToString(it.key) }
    return repo.insert(BoardModel().copy(pieces = newBoardMap, player = newBoard.player))
  }

  fun updateBoardWithMove(boardId: String, initial: String, final: String): BoardModel? {
    val boardModel = repo.findByIdOrNull(boardId)

    if (boardModel == null) {
      return null
    } else {
      val pieces = boardModel.pieces.mapKeys { stringToTriple(it.key) }
      val player = boardModel.player
      val movedBoard =
          moveBoard(Board(pieces, player), Move(stringToTriple(initial), stringToTriple(final)))
      val stringMap = movedBoard.pieces.mapKeys { tripleToString(it.key) }
      return repo.save(BoardModel(boardId, stringMap, player))
    }
  }

  fun getString(boardId: String): String? {
    val boardModel = repo.findByIdOrNull(boardId)
    if (boardModel == null) {
      return null
    } else {
      val pieces = boardModel.pieces.mapKeys { stringToTriple(it.key) }
      return Board(pieces, boardModel.player).toString()
    }
  }
}
