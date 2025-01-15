package com.fourcompany.demo1.controller;

import com.fourcompany.demo1.domain.Board;
import com.fourcompany.demo1.domain.Notice;
import com.fourcompany.demo1.service.BoardService;
import com.fourcompany.demo1.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {

    private final NoticeService noticeService;
    public NoticeRestController(
            NoticeService noticeService
    ) {
        this.noticeService = noticeService;
    }

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return noticeService.createNotice(params);
    }

    @GetMapping("/list")
    public List<Notice> list(){
        return noticeService.listNotice();

    }
    @GetMapping("/detail") //이 안에 있는 주소값은 꼭 유니크해야함!!
    public Notice detail(@RequestParam Integer id){
        return noticeService.detailNotice(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return noticeService.updateNotice(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return noticeService.deleteNotice(Integer.parseInt(params.get("id") + ""));
    }
}



