package com.example.aparking.service;

import com.example.aparking.domain.repository.BoardRepository;
import com.example.aparking.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// Repository를 주입하기 위해 사용
@AllArgsConstructor

// 서비스 계층임을 명시
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional // 선언적 트랜잭션 (트랜잭션을 적용)
    public Long savePost(BoardDto boardDto){

        // save(): JpaRepository에 정의된 메서드로, DB에 INSERT, UPDATE를 담당함
        // 매개변수로는 Entity를 전달함
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
