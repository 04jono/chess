package net.jonochen.chess

import net.jonochen.chess.game.Board
import net.jonochen.chess.game.Move
import net.jonochen.chess.game.moveBoard
import net.jonochen.chess.model.*
import net.jonochen.chess.repository.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class GameController (@Autowired val repo : Repository){

    @GetMapping("board")
    fun print() : String {
        val bd = Board()
        println(bd.toString())
        val m = Move(Triple(0,0,0), Triple(2,0,0))
        val newBoard = moveBoard(bd, m)
        println(newBoard.toString())
        return newBoard.toString()
    }

    @GetMapping("post")
    fun postLanding() : String {
        return "Posted"
    }

    @PostMapping("post")
    fun post() : BoardModel {
        val newBoard = Board()
        val newBoardMap = newBoard.state.pieces.mapKeys { it.key.first.toString() + "," + it.key.second.toString() + "," + it.key.third.toString() }
        val boardModel = BoardModel().copy(pieces=newBoardMap, player=newBoard.state.player)
        return repo.insert(boardModel)
    }
}