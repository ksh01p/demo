package com.fourcompany.demo1.service.impl;

import com.fourcompany.demo1.domain.Board;
import com.fourcompany.demo1.domain.Notice;
import com.fourcompany.demo1.repository.BoardRepository;
import com.fourcompany.demo1.repository.NoticeRepository;
import com.fourcompany.demo1.service.BoardService;
import com.fourcompany.demo1.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(
            NoticeRepository noticeRepository
    ) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Map<String, Object> createNotice(Map<String, Object> params) {
        System.out.println("createNotice");
        Notice notice = new Notice();

        notice.setId(Integer.parseInt(params.get("id") + ""));
        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());
        notice.setAuthor(params.get("author").toString());
        notice.setDate(params.get("date").toString());

        noticeRepository.save(notice);
        return null;
    }

    @Override
    public Map<String, Object> updateNotice(Map<String, Object> params) {
        System.out.println("updateNotice");
        Notice notice = noticeRepository.findById(Integer.parseInt(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));

        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());
        notice.setAuthor(params.get("author").toString());
        notice.setDate(params.get("date").toString());

        noticeRepository.save(notice);
        return null;
    }
    
    @Override
    public List<Notice> listNotice() {
        return noticeRepository.findAll();
    }


    @Override
    public Notice detailNotice(Integer id) {
        return noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }


    @Override
    public Map<String, Object> deleteNotice(Integer id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        noticeRepository.delete(notice);
        return null;
    }
}

