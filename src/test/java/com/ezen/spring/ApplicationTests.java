package com.ezen.spring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ApplicationTests {

	private static final String API_KEY = "55f8a16d3b5e46ca9eaa4906807f746d"; // RAWG API 키
	private static final String API_URL = "https://api.rawg.io/api/games?key=" + API_KEY;

	@Test
	void contextLoads() {
	}

	@Test
	void testApi() {
		// RestTemplate 생성
		RestTemplate restTemplate = new RestTemplate();

		try {
			// API 호출
			String response = restTemplate.getForObject(API_URL, String.class);

			// JSON 응답 처리
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			JsonNode results = root.path("results");

			// 인기 게임 리스트 출력
			System.out.println("=== Popular Games ===");
			for (JsonNode game : results) {
				String name = game.path("name").asText(); // 게임 이름
				String released = game.path("released").asText(); // 출시일
				double rating = game.path("rating").asDouble(); // 평점

				System.out.printf("Name: %s, Released: %s, Rating: %.1f%n", name, released, rating);
			}

		} catch (Exception e) {
			System.err.println("Error while fetching data: " + e.getMessage());
		}
	}

}
