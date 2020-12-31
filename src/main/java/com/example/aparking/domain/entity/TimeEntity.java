package com.example.aparking.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter

// 테이블로 매핑하지 않고, 자식 클래스(엔티티)에게 매핑정보를 상속
@MappedSuperclass

// JPA에게 해당 entity는 Auditing 기능을 사용한다는 것을 알림
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity {

    // entity가 처음 저장될 때 생성일을 주입
    @CreatedDate

    // 생성일은 update가 필요 없음
    @Column(updatable = false)
    private LocalDateTime createdDate;

    // entity 수정 시 수정일자를 주입
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
