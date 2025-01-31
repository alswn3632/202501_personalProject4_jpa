package com.ezen.spring.controller;

import com.ezen.spring.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/game/*")
@RequiredArgsConstructor
@Controller
public class GameController {

    private final GameService GameService;

}
