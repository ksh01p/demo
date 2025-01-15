package com.fourcompany.demo1.repository;


import com.fourcompany.demo1.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{
}


