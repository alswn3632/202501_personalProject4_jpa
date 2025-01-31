package com.ezen.spring.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ReviewDTO {

    private Long rno; // 리뷰 고유 ID
    private Long gno; // 게임 ID
    private Long mno; // 리뷰 작성자 ID
    private Double rating; // 리뷰 평점
    private String content; // 리뷰 내용
    private String isDel; // 삭제 여부

    private LocalDateTime regDate;  // 게시글 생성 시간
    private LocalDateTime modDate;  // 게시글 수정 시간
}
