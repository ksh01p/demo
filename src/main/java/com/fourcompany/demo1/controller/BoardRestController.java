package com.fourcompany.demo1.controller;

import com.fourcompany.demo1.domain.Board;

import com.fourcompany.demo1.dto.BoardDto;
import com.fourcompany.demo1.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    private final BoardService boardService;
    public BoardRestController(
            BoardService boardService
    ) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public ResponseEntity<BoardDto.CreateResDto> createBoard(@RequestBody BoardDto.CreateReqDto requestDto) {
        BoardDto.CreateResDto responseDto = boardService.createBoard(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/list")
    public List<Board> list(){
        return boardService.listBoard();

    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Board detail(@RequestParam Integer id){
        return boardService.detailBoard(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return boardService.updateBoard(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return boardService.deleteBoard(Integer.parseInt(params.get("id") + ""));
    }
}



