package com.ezen.spring.controller;

import com.ezen.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/review/*")
@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService ReviewService;

    @GetMapping("/register")
    public void register(){}

}
