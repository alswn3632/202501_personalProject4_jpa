package com.ezen.spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Board extends TimeBase{
    // @Entity : DB의 테이블 클래스를 의미함
    // DTO : 객체를 생성하는 클래스를 의미함
    // 자주 쓰는 코드를 base class로 별도 관리함
    // ex) regDate / modDate / isDel

    // id = 기본키
    // 기본키 생성 전략 : GeneratedValue

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 생성
    private Long bno; // 게시판 고유 번호
    // BoardRepository에서 id의 자료형을 클래스로 넣어줘야하기 때문에 Board Entity의 자료형 또한 클래스형식으로 넣어줘야한다.

    @Column(length = 200, nullable = false)
    private String title; // 게시판 제목

    @Column(length = 200, nullable = false)
    private String writer; // 게시판 작성자

    @Column(nullable = false)
    private Long mno;

    @Column(length = 2000, nullable = false)
    private String content; // 게시판 내용

    @Column(length = 100, nullable = false)
    private String category; // 게시판 종류 (예: "공지사항", "자유게시판" 등)

    @Column(length = 5, nullable = false)
    private String isDel = "N"; // 기본값 설정 (삭제 상태 기본값: N)

    // 생성 시 초기화 값을 지정 : 객체가 생성될 때 객체의 기본 값 생성
    // @Builder.Default
    // private int point = 0;

}
