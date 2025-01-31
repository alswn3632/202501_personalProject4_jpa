package com.ezen.spring.service;

import com.ezen.spring.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService{

    private final GameRepository GameRepository;

}
