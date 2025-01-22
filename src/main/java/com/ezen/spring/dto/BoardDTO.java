package com.ezen.spring.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class BoardDTO {
    private Long bno;            // 게시판 고유 번호
    private String title;        // 게시판 제목
    private String writer;       // 게시판 작성자
    private Long mno;            // 작성자 고유 번호
    private String content;      // 게시판 내용
    private String category;     // 게시판 종류
    private String isDel;        // 삭제 상태

    private LocalDateTime regDate;  // 게시글 생성 시간
    private LocalDateTime modDate;  // 게시글 수정 시간
}
