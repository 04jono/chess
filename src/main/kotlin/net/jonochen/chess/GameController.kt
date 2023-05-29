package net.jonochen.chess

import net.jonochen.chess.model.*
import net.jonochen.chess.repository.Repository
import net.jonochen.chess.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class GameController(@Autowired val repo: Repository, @Autowired val gameService: GameService) {

  @GetMapping("string") fun print(@RequestBody id: String): ResponseEntity<String> {
    val res = gameService.getString(id)
    return if(res == null){
      ResponseEntity(null, HttpStatus.BAD_REQUEST)
    } else {
      ResponseEntity(res, HttpStatus.ACCEPTED)
    }
  }

  @PostMapping("create")
  fun postNewBoard(): ResponseEntity<BoardModel> {
    return ResponseEntity(gameService.createNewBoard(), HttpStatus.CREATED)
  }

  @PutMapping("update")
  fun postBoard(@RequestBody body: Map<String, String>): ResponseEntity<BoardModel> {
    return if (body["boardId"] == null || body["initial"] == null || body["final"] == null) {
      ResponseEntity(null, HttpStatus.BAD_REQUEST)
    } else {
      ResponseEntity(
        gameService.updateBoardWithMove(body["boardId"]!!, body["initial"]!!, body["final"]!!),
        HttpStatus.ACCEPTED)
    }
  }
}
