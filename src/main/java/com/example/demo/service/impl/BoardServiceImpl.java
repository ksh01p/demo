package com.example.demo.service.impl;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    public BoardServiceImpl(
            BoardRepository boardRepository
    ) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Map<String, Object> createBoard(Map<String, Object> params) {
        System.out.println("createBoard");
       /**/
    }
    @Override
    public Map<String, Object> updateBoard(Map<String, Object> params) {
        System.out.println("updateBoard");
        /**/
    }
    @Override
    public List<Board> listBoard() {
        /**/

    }


    @Override
    public Board detailBoard(Integer id) {
        /**/
    }


    @Override
    public Map<String, Object> deleteBoard(Integer id) {
        /**/

    }





}
