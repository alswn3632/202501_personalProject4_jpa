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
public class Review extends TimeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long rno; // 리뷰 고유 ID

    @Column(nullable = false)
    private Long gno; // 게임 ID (RAWG에서 제공하는 고유 ID)

    @Column(nullable = false)
    private Long mno; // 리뷰 작성자 ID (회원 ID, FK 예정)

    @Column(nullable = false)
    private Double rating; // 리뷰 평점 (0.0 ~ 5.0, 0.5 단위)

    @Column(length = 2000, nullable = false)
    private String reviewText; // 리뷰 내용

    @Column(length = 5, nullable = false)
    private String isDel = "N"; // 삭제 여부 기본값: "N"
}
