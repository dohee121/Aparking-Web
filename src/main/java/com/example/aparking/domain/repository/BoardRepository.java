package com.example.aparking.domain.repository;

import com.example.aparking.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository의 제네릭 타입에는 Entity 클래스와 PK의 타입을 명시하면 됨
// JpaRepository에는 일반적으로 많이 사용하는 데이터 조작 함수가 정의되어 있기 때문에
// CRUD 작업이 편해짐
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
