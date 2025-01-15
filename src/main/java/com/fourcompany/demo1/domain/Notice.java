package com.fourcompany.demo1.domain;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Notice {
    @Id
    Integer id;

    String title;
    String content;
    String author;
    String date;
}
