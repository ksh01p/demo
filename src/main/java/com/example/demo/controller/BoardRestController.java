package com.example.demo.controller;


import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return boardService.createBoard(params);

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



