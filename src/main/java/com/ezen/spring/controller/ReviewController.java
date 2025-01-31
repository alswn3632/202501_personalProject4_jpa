package com.ezen.spring.controller;

import com.ezen.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/review/*")
@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService ReviewService;

}
