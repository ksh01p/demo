package com.fourcompany.demo1.service;

import com.fourcompany.demo1.domain.Board;
import com.fourcompany.demo1.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    BoardDto.CreateResDto createBoard(BoardDto.CreateReqDto createReqDto);
    Map<String, Object> updateBoard(Map<String, Object> params);
    Map<String, Object> deleteBoard(Integer id);
    List<Board> listBoard();
    Board detailBoard(Integer id);
}

