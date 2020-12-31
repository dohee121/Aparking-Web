package com.example.aparking.controller;

import com.example.aparking.dto.BoardDto;
import com.example.aparking.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 컨트롤러임을 명시
// MVC에서 컨트롤러로 명시된 클래스의 메서드들은 반환 값으로 템플릿 경로를 작성하거나, redirect를 해줘야 함
// 템플릿 경로는 templates 패키지를 기준으로 한 상대경로임
@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    // URL을 매핑해줌. HTTP Method에 맞는 어노테이션을 작성하면 됨.
    @GetMapping("/")
    public String list(){
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
