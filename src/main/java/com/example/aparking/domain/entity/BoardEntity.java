package com.example.aparking.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 파라미터가 없는 기본 생성자 추가 (JPA 사용 위해 기본 생성자 생성은 필수)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// 모든 필드에 getter 자동생성
@Getter

// 객체를 테이블과 매핑할 엔티티라고 JPA에게 알려줌 (엔티티 매핑)
// @Entity가 붙은 클래스는 JPA가 관리하며, 이를 엔티티 클래스라 함
@Entity

// 엔티티 클래스와 매핑되는 테이블 정보를 명시
// name 속성으로 테이블명을 작성할 수 있으며, 생략 시 엔티티 이름이 테이블명으로 자동 매핑됨
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id // 테이블의 PK
    // 기본키로 대체키를 사용할 때, 기본키 값 생성 전략을 명시함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼을 매핑
    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 빌더패턴 클래스 생성
    // @Setter 대신 빌더패턴을 사용해야 안정성을 보장할 수 있음
    @Builder
    public BoardEntity(Long id, String title, String content, String writer){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
