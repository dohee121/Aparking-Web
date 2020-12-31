package com.example.aparking.dto;

import com.example.aparking.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor

// dto는 Controller <-> Service <-> Repository 간에 필요한 데이터를 캡슐화한 데이터 전달 객체임
// 각 계층에서 필요한 객체전달은 Entity 객체가 아닌 dto 객체를 통해 주고받는 것이 좋음
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // dto에서 필요한 부분을 빌더패턴을 통해 entity로 만듦
    // 필요한 Entity는 이런식으로 추가하면 됨
    public BoardEntity toEntity() {
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
