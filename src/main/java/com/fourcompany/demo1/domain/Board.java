package com.fourcompany.demo1.domain;
import com.fourcompany.demo1.dto.BoardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: 데이터베이스에서 ID를 자동 생성
    Integer id;

    String title;
    String content;
    String author;

    public BoardDto.CreateResDto toCreateResDto() {
        BoardDto.CreateResDto responseDto = new BoardDto.CreateResDto();
        responseDto.setId(this.id);
        responseDto.setTitle(this.title);
        responseDto.setContent(this.content);
        responseDto.setAuthor(this.author);
        return responseDto;
    }
}
