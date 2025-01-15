package com.fourcompany.demo1.service.impl;

import com.fourcompany.demo1.domain.Board;
import com.fourcompany.demo1.dto.BoardDto;
import com.fourcompany.demo1.repository.BoardRepository;
import com.fourcompany.demo1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    public BoardServiceImpl(
            BoardRepository boardRepository
    ) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardDto.CreateResDto createBoard(BoardDto.CreateReqDto createReqDto) {
        System.out.println("createBoard");
        return boardRepository.save(createReqDto.toEntity()).toCreateResDto();
    }
//    public BoardDto.CreateResDto createBoard (BoardDto.CreateResDto createResDto) {
//        Board board = new Board();
//        BoardDto.CreateResDto createResDto = new BoardDto.CreateResDto();
//        board.setTitle(createResDto.getTitle());
//        board.setContent(createResDto.getContent());
//        board.setAuthor(createResDto.getAuthor());
//
//        // 엔티티 저장
//        Board savedBoard = boardRepository.save(board);
//
//        // 저장된 결과를 응답 DTO로 변환
//        BoardDto.CreateResDto responseDto = new BoardDto.CreateResDto();
//        responseDto.setId(savedBoard.getId());
//        responseDto.setTitle(savedBoard.getTitle());
//        responseDto.setContent(savedBoard.getContent());
//        responseDto.setAuthor(savedBoard.getAuthor());
//        System.out.println("createBoard");
//        Board board = new Board();
//        board.setId(Integer.parseInt(params.get("id") + ""));
//        board.setTitle(params.get("title").toString());
//        board.setContent(params.get("content").toString());
//        board.setAuthor(params.get("author").toString());
//        boardRepository.save(board);
//        return null;




    @Override
    public Map<String, Object> updateBoard(Map<String, Object> params) {
        System.out.println("updateBoard");
        Board board = boardRepository.findById(Integer.parseInt(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));

        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        board.setAuthor(params.get("author").toString());
        boardRepository.save(board);
        return null;
    }
    
    @Override
    public List<Board> listBoard() {
        return boardRepository.findAll();
    }


    @Override
    public Board detailBoard(Integer id) {
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }


    @Override
    public Map<String, Object> deleteBoard(Integer id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        boardRepository.delete(board);
        return null;
    }
}

