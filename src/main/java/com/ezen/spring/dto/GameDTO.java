package com.ezen.spring.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class GameDTO {

    private Long gno; // 게임 ID
    private String name; // 게임 이름
    private String slug; // URL-friendly ID
    private String releaseDate; // 출시일
    private String platforms; // 지원 플랫폼 (JSON 형태)
    private String stores; // 구매 가능한 스토어 (JSON 형태)
    private Double rating; // 평점
    private String backgroundImage; // 게임 대표 이미지 URL
    private String genres; // 게임 장르 (JSON 형태)
    private String description; // 게임 설명

}
