package com.ezen.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Game {

    @Id
    private Long gno; // 게임 ID (RAWG에서 제공하는 고유 ID)

    @Column(length = 255, nullable = false)
    private String name; // 게임 이름

    @Column(length = 255, nullable = false, unique = true)
    private String slug; // URL-friendly ID

    @Column(nullable = false)
    private String releaseDate; // 출시일

    @Column(length = 500, nullable = false)
    private String platforms; // 지원 플랫폼 (JSON 형태로 저장 가능)

    @Column(length = 500, nullable = false)
    private String stores; // 구매 가능한 스토어 (JSON 형태로 저장 가능)

    @Column(nullable = false)
    private Double rating; // 평점

    @Column(length = 500, nullable = false)
    private String backgroundImage; // 게임 대표 이미지 URL

    @Column(length = 500, nullable = false)
    private String genres; // 게임 장르 (JSON 형태로 저장 가능)

    @Column(length = 2000, nullable = false)
    private String description; // 게임 설명

}
