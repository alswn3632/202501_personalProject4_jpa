package com.ezen.spring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

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

			// 인기 게임 리스트 출력 ㅇㅅㅇ
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

	@Test
	void searchGameByKoreanName() {
		RestTemplate restTemplate = new RestTemplate();

		String koreanGameName = "call of duty";

		try {
			// 한국어로 검색 URL 생성
			String searchUrl = API_URL + "&search=" + koreanGameName;

			// API 호출
			String response = restTemplate.getForObject(searchUrl, String.class);

			// JSON 응답 처리
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(response);
			JsonNode results = root.path("results");  // 'results' 배열 처리

			if (results.isArray() && results.size() > 0) {
				for (JsonNode game : results) {
					String englishName = game.path("name").asText();    // 영어 제목
					String koreanName = game.path("translations").path("kor").asText();  // 한국어 제목

					// 한국어로 검색 후, 영문 제목과 매칭을 시도
					if (koreanName.equalsIgnoreCase(koreanGameName) || englishName.equalsIgnoreCase(koreanGameName)) {
						String name = game.path("name").asText();         // 게임 이름
						String released = game.path("released").asText(); // 출시일
						double rating = game.path("rating").asDouble();   // 평점
						String id = game.path("id").asText(); // id 값
						// 영어 ver // 한글 ver 안될듯 영어 게임은 그냥 영어로 두는게?

						System.out.println("=== Game Information ===");
						System.out.printf("Name: %s%nReleased: %s%nRating: %.1f%n", name, released, rating);
						System.out.println(id);
						return;
					}
				}

				System.out.println("No results found for: " + koreanGameName);
			} else {
				System.out.println("No results found.");
			}

		} catch (Exception e) {
			System.err.println("Error while fetching data: " + e.getMessage());
		}
	}

}
