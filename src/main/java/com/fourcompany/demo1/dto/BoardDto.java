package com.fourcompany.demo1.dto;


import com.fourcompany.demo1.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


public class BoardDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateResDto {
        private Integer id;
        private String title;
        private String content;
        private String author;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String content;
        private String author;

        public Board toEntity() {
            Board board = new Board();
            board.setTitle(this.title);
            board.setContent(this.content);
            board.setAuthor(this.author);
            return board;
        }


    }
}
